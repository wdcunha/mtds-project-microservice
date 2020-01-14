cd C:\Users\dafon\Dropbox\__Mestrado_EI\MTSDS\Trabalho_MTSDS_2020\_ProjetoEntrega\minikube

minikube status

kubectl get all

minikube addons enable ingress

kubectl apply -f mysql.yaml

kubectl apply -f rabbitmq.yaml

kubectl apply -f store.yaml

kubectl apply -f product-bk_pod.yaml

kubectl apply -f cart-bk_pod.yaml

kubectl apply -f order-bk_pod.yaml

kubectl apply -f ingress.yaml

kubectl get all

kubectl get ingress

minikube ip

cls