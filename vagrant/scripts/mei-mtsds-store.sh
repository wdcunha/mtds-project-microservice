#!/bin/bash
echo "**** Begin installing mei-mtsds-store pods"

#Install rabbitMQ
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/rabbitmq.yaml
echo "RabbitMQ pod installed"

#Install MySQL
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/mysql.yaml
echo "mySQL pod installed"

#List pods
kubectl get all

#Install Store Pods
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/store.yaml
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/product-bk_pod.yaml
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/cart-bk_pod.yaml
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/order-bk_pod.yaml
echo "Store pods installed"

#Activate ingress
minikube addons enable ingress
kubectl apply -f https://github.com/dtafonso/mei-mtsds-store/raw/master/minikube/ingress.yaml

echo "**** End preparing pods"
