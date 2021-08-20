#!/bin/bash
# This starts the pipeline new-pipeline with a given 

set -e -u -o pipefail
declare -r SCRIPT_DIR=$(cd -P $(dirname $0) && pwd)
declare COMMAND="help"

GIT_URL=https://github.com/wpernath/quarkus-simple.git
GIT_REVISION=main
PIPELINE=gitops-dev-pipeline
CONTEXT_DIR=the-source
IMAGE_NAME=quay.io/wpernath/quarkus-simple-wow
IMAGE_USER=wpernath
IMAGE_PASSWORD=
TARGET_NAMESPACE=quarkus-dev

valid_command() {
  local fn=$1; shift
  [[ $(type -t "$fn") == "function" ]]
}

info() {
    printf "\n# INFO: $@\n"
}

err() {
  printf "\n# ERROR: $1\n"
  exit 1
}

command.help() {
  cat <<-EOF
  Starts a new pipeline in current kubernetes context

  Usage:
      pipeline.sh [command] [options]
  
  Examples:
      pipeline.sh init -u wpernath -p <secret> # installs and creates all tasks, pvc and secrets
      pipeline.sh start -u wpernath -p <nope> -t art-tekton
      pipeline.sh stage -r 1.2.3 
      pipeline.sh logs
  
  COMMANDS:
      init                           creates ConfigMap, Tasks and Pipelines into current context
                                     it also creates a secret with -u/-p user/pwd for GitHub.com access
      start                          starts the given pipeline
      stage                          starts the stage pipeline and creates a release in quay.io and github
      logs                           shows logs of the last pipeline run
      help                           Help about this command

  OPTIONS:
      -u, --registry-user           User to store the image into quay.io ($IMAGE_USER)
      -p, --registry-password       Password to store the image into quay.io ($IMAGE_PASSWORD)
      -c, --context-dir             Which context-dir to user ($CONTEXT_DIR)
      -t, --target-namespace        Which target namespace to start the app ($TARGET_NAMESPACE)
      -g, --git-repo                Which quarkus repository to clone ($GIT_URL)
      -r, --git-revision            Which git revision to use ($GIT_REVISION)
      
EOF
}

command.test() {
  cat > /tmp/tr.yaml <<-EOF
apiVersion: tekton.dev/v1beta1
kind: TaskRun
metadata:
  name: git-test-run-$(date "+%Y%m%d-%H%M%S")
spec:
  params:
    - name: kustomize-dir
      value: config/overlays/dev
  workspaces:
    - name: source
      persistentVolumeClaim:
        claimName: builder-pvc      
  serviceAccountName: pipeline-bot
  taskRef:
    name: extract-kustomize-digest
EOF

oc apply -f /tmp/tr.yaml
}



while (( "$#" )); do
  case "$1" in
    start|logs|init|test|stage)
      COMMAND=$1
      shift
      ;;
    -c|--context-dir)
      CONTEXT_DIR=$2
      shift 2
      ;;
    -t|--target-namespace)
      TARGET_NAMESPACE=$2
      shift 2
      ;;
    -u|--registry-user)
      IMAGE_USER=$2
      shift 2
      ;;
    -p|--registry-password)
      IMAGE_PASSWORD=$2
      shift 2
      ;;
    -g|--git-repo)
      GIT_URL=$2
      shift 2
      ;;
    -r|--git-revision)
      GIT_REVISION=$2
      shift 2
      ;;
    -l|--pipeline)
      PIPELINE=$2
      shift 2
      ;;
    --)
      shift
      break
      ;;
    -*|--*)
      command.help
      err "Error: Unsupported flag $1"
      ;;
    *) 
      break
  esac
done


command.init() {
  # This script imports the necessary files into the current project 
  
  oc apply -f infra/maven-settings-cm.yaml
  oc apply -f infra/maven-artifact-cache-pvc.yaml
  oc apply -f infra/sa.yaml

  oc apply -f tasks/kustomize-task.yaml
  oc apply -f tasks/extract-digest-task.yaml
  oc apply -f tasks/extract-digest-from-kustomize-task.yaml
  oc apply -f tasks/create-release.yaml
  
  oc apply -f tasks/maven-task.yaml
  oc apply -f tasks/git-update-deployment.yaml
  oc apply -f tasks/bash-task.yaml

  oc apply -f pipelines/tekton-pipeline.yaml
  oc apply -f pipelines/stage-release.yaml

  cat > /tmp/tekton-git-secret.yaml <<-EOF
apiVersion: v1
kind: Secret
metadata:
  name: git-user-pass
  annotations:
    tekton.dev/git-0: https://github.com # Described below
type: kubernetes.io/basic-auth
stringData:
  username: $IMAGE_USER
  password: $IMAGE_PASSWORD
EOF

  oc apply -f /tmp/tekton-git-secret.yaml
}


command.logs() {
    tkn pr logs -f -L
}

command.start() {
  cat > /tmp/pipelinerun.yaml <<-EOF
apiVersion: tekton.dev/v1beta1
kind: PipelineRun
metadata:
  name: $PIPELINE-run-$(date "+%Y%m%d-%H%M%S")
spec:
  params:
    - name: git-url
      value: '$GIT_URL'
    - name: git-revision
      value: $GIT_REVISION
    - name: context-dir
      value: $CONTEXT_DIR
    - name: image-name
      value: $IMAGE_NAME
    - name: image-username
      value: $IMAGE_USER
    - name: image-password
      value: $IMAGE_PASSWORD
    - name: target-namespace
      value: $TARGET_NAMESPACE
  workspaces:
    - name: shared-workspace
      persistentVolumeClaim:
        claimName: builder-pvc 
    - configMap:
        name: maven-settings
      name: maven-settings
  pipelineRef:
    name: $PIPELINE
  serviceAccountName: pipeline-bot
EOF

    oc apply -f /tmp/pipelinerun.yaml
}


command.stage() {
  cat > /tmp/pipelinerun.yaml <<-EOF
apiVersion: tekton.dev/v1beta1
kind: PipelineRun
metadata:
  name: gitops-stage-release-run-$(date "+%Y%m%d-%H%M%S")
spec:
  params:
    - name: release-name
      value: $GIT_REVISION
  workspaces:
    - name: shared-workspace
      persistentVolumeClaim:
        claimName: builder-pvc 
    - configMap:
        name: maven-settings
      name: maven-settings
  pipelineRef:
    name: gitops-stage-release
  serviceAccountName: pipeline-bot
EOF

    oc apply -f /tmp/pipelinerun.yaml
}

main() {
  local fn="command.$COMMAND"
  valid_command "$fn" || {
    command.help
    err "invalid command '$COMMAND'"
  }

  cd $SCRIPT_DIR
  $fn
  return $?
}

main
