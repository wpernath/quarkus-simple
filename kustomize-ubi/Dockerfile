FROM registry.access.redhat.com/ubi8/ubi-minimal:8.4

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'
# Install java and the run-java script
# Also set up permissions for user `1001`
RUN microdnf install curl ca-certificates wget tar gzip bash podman buildah \
    && microdnf update \
    && microdnf clean all 
    
RUN curl -sLO https://github.com/kubernetes-sigs/kustomize/releases/download/kustomize%2Fv4.1.3/kustomize_v4.1.3_linux_amd64.tar.gz
RUN tar -xzf kustomize*.tar.gz
RUN cp kustomize /usr/local/bin/

#USER 1001


