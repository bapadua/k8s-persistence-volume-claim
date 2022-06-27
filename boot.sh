#!/bin/bash
echo "building application writer"
cd ./demo-k8s-pv-writer
chmod +x ./gradlew
./gradlew clean build -x test

echo "building application reader"
cd ./demo-k8s-pv-reader
chmod +x ./gradlew
./gradlew clean build -x test
