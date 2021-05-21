# Build the manager binary
#FROM quay.io/operator-framework/helm-operator:v1.7.2
FROM registry.redhat.io/openshift4/ose-helm-operator:v4.7

ENV HOME=/opt/helm
COPY watches.yaml ${HOME}/watches.yaml
COPY helm-charts  ${HOME}/helm-charts
WORKDIR ${HOME}
