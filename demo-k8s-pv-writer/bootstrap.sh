#!/bin/bash
echo "creating volume"
kubectl apply -f .\\k8s\\pv-volume.yaml
echo "volume created"
echo "creating claim"
kubectl apply -f .\\k8s\\pv-claim.yaml
echo "creating created"
echo "building application"
.\\gradlew clean build
echo "app built"
echo "building image"
docker build -t bapadua/demo-pv-writer:latest .
echo "image built"
echo "pushing image"
docker push bapadua/demo-pv-writer:latest
echo "image pushed"
echo "creating pod"
kubectl apply -f .\\k8s\\pv-pod.yaml
sleep 20
kubectl port-forward demo-pv-writer-pod 8083:8083
