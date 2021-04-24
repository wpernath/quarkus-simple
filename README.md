# simple-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Intention
This is the example, I am using in my article "Automated Application Packaging and Distribution with OpenShift", you could read here: 

https://www.opensourcerers.org/2021/04/26/automated-application-packaging-and-distribution-with-openshift-part-12/

## Prerequisites
You simply need an OpenShift instance. For example CodeReady Containers, which you can download and use from here:

https://cloud.redhat.com/openshift/create/local

To build this example locally, you should also have installed:

- kustomize
- skopeo (to copy the image to quay.io/dockerhub)
- maven
- docker for desktop


## Running the application in dev mode
You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev -DskipTests
```

## Creating a docker image
The application can be packaged using:
```shell script
./mvnw package -DskipTests
docker build -f src/main/docker/Dockerfile.jvm -t wpernath/simple-quarkus .
skopeo copy docker://wpernath/simple-quarkus:latest docker://quay.io/wpernath/simple-quarkus:latest
```

## Run the docker image locally
```shell script
docker run -i --rm -p 8080:8080 wpernath/simple-quarkus:latest
```

## Creating a tag on DockerHub or quay.io
```shell script
skopeo copy docker://wpernath/simple-quarkus:latest docker://quay.io/wpernath/simple-quarkus:stage
```
