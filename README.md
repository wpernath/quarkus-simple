# simple-quarkus project
This is a simple demo application written in Java with [Quarkus](https://quarkus.io) to demonstrate how to work in a Kubernetes environment.

## Intention
This is the example, I am using in my article series **Automated Application Packaging and Distribution with OpenShift** which you could read here: 

- [Chapter one](https://www.opensourcerers.org/2021/04/26/automated-application-packaging-and-distribution-with-openshift-part-12/) talks about container images and explains all the basic files and gives you a guide through OpenShift Templates and Kustomize as a base technology for application packaging
- [Chapter two](https://www.opensourcerers.org/2021/05/24/automated-application-packaging-and-distribution-with-openshift-part-23/) provides an overview of the various packaging formats, namely Helm Charts and Kubernetes Operators, and explains how they differ from each other and how to create them
- [Chapter three](https://www.opensourcerers.org/2021/07/26/automated-application-packaging-and-distribution-with-openshift-tekton-pipelines-part-34-2/) gives you a detailed view of Tekton / OpenShift Pipelines and helps you to quickly start your CI/CD process
- [And finally chapter four](https://www.opensourcerers.org/2021/09/06/automated-application-packaging-and-distribution-with-openshift-gitops-and-argocd-part-44) provides a detailed overview of GitOps and how to use it with OpenShift. 

## Prerequisites
You simply need an OpenShift 4.7 or 4.8 instance. For example CodeReady Containers, which you can download and use from here for free:

https://cloud.redhat.com/openshift/create/local

## Chapters corresponding with folders in this repository
This repository contains all the files necessary to follow the blog posts. It is derived into several folders. 

### Chapter One - Basic Development 
If you’re reading chapter one, you can find the corresponding files in those folders:

- `kubernetes-files`: What are the necessary files to (re-) deploy your app into Kubernetes? You can also find the OpenShift Template file in here.
- `kustomize`: All necessary files to (re-) deploy your app into Kubernetes based on Kustomize
- `kustomize_ext`: A more sophisticated example with patches etc


### Chapter Two - Helm Charts and Kubernetes Operators
If you’re reading chapter two, you can find all the corresponding files in those folders:

- `helm`: How to create a Helm Chart for this quarkus application
- `operator`: How to create a Kubernetes Operator for this quarkus application

### Chapter Three: Tekton / OpenShift Pipelines
You can find all necessary files to follow chapter three in the folder `tektondev`. 

To prepare your OpenShift cluster, you have to install the Operator `OpenShift Pipelines`. And then you can install everything by executing the script:

```bash
$> ./tektondev/pipeline.sh init
```

To execute the pipeline, simply start:

```bash
$> ./tektondev/pipeline.sh start -u <quay.io user> -p <quay.io password hash>
```


### Chapter Four: GitOps and ArgoCD
You can find all necessary files to follow chapter four in the folder `gitops`. To prepare your OpenShift cluster, you need to install two Operators:
- OpenShift Pipelines
- OpenShift GitOps

Then you can install the pipelines by executing the following script:

```bash
$> ./gitops/tekton/pipeline.sh init -u <git user> -p <git hash>
```

To start the development pipeline, execute
```bash
$> ./gitops/tekton/pipeline.sh start -u <quay.io user> -p <quay.io hash>
```

To start the staging pipeline, execute
```bash
$> ./gitops/tekton/pipeline.sh stage
```

After you’ve followed the corresponding section „Creating a stage release pipeline“. 

