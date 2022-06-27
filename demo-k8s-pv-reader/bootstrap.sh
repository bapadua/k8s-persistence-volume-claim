#!/bin/bash
echo "building application"
.\\gradlew clean build -x test
echo "app built"
echo "building image"
docker build -t bapadua/demo-pv-reader:latest .
echo "image built"
echo "pushing image"
docker push bapadua/demo-pv-reader:latest
echo "image pushed"
echo "creating pod"
kubectl apply -f .\\k8s\\pv-pod.yml
echo "pod deployed"
