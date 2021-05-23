# simple-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Intention
This is the example, I am using in my article "Automated Application Packaging and Distribution with OpenShift", you could read here: 

https://www.opensourcerers.org/2021/04/26/automated-application-packaging-and-distribution-with-openshift-part-12/

And part two, which focuses on Helm Charts and Kubernetes Operators:
https://www.opensourcerers.org/2021/05/24/automated-application-packaging-and-distribution-with-openshift-part-23/

## Prerequisites
You simply need an OpenShift instance. For example CodeReady Containers, which you can download and use from here:

https://cloud.redhat.com/openshift/create/local

To build this example locally, you should also have installed:

- kustomize
- skopeo (to copy the image to quay.io/dockerhub)
- maven
- docker for desktop
- helm sdk
- Operator SDK


## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev -DskipTests
```

## Creating a docker image
The application can be packaged using:
```shell script
./mvnw clean package -DskipTests
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/wpernath/simple-quarkus .
docker push -a quay.io/wpernath/simple-quarkus
```

## Run the docker image locally
```shell script
docker run -i --rm -p 8080:8080 quay.io/wpernath/simple-quarkus:latest
```

## Creating a tag on DockerHub or quay.io
```shell script
docker tag quay.io/wpernath/simple-quarkus:latest quay.io/wpernath/simple-quarkus:stage
```

Or:
```shell script
docker tag quay.io/wpernath/simple-quarkus:latest quay.io/wpernath/simple-quarkus:1.2.0
```

## Helm
To build the helm chart, have a look at the folder `helm`. To build your chart, call:

```shell script
helm package helm -u
```

To install your chart in a running Kubernetes instance, call:

```shell script
helm install quarkus-simple quarkus-simple-0.0.1.tgz
helm upgrade --install quarkus-simple quarkus-simple-0.0.1.tgz
```

## Operator
To build the operator, download the operator-sdk, cd into the operator directory and call

```shell script
make docker-build docker-push
```

For packaging the whole operator with OLM, call
```shell script
make bundle bundle-build bundle-push
```
