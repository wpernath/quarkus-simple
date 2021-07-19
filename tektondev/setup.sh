#!/bin/bash
# This script imports the necessary files into the current project 
#
oc apply -f infra/maven-settings-cm.yaml
oc apply -f infra/maven-artifact-cache-pvc.yaml

oc apply -f tasks/kustomize-task.yaml
oc apply -f tasks/maven-task.yaml

oc apply -f pipelines/tekton-pipeline.yaml

