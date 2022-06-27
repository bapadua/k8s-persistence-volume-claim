#!/bin/bash
echo "Removing kubernetes testing deployment"
echo "Removing pods"
kubectl delete pod demo-pv-writer-pod
kubectl delete pod demo-pv-reader-pod
echo "Pods removed"
echo "Removing volume claim"
kubectl delete pvc demo-pv-claim
echo "Volume Claim removed"
echo "Removing Persistent Volume"
kubectl delete pv demo-pv-volume
