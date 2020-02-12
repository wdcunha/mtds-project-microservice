# MTSDS Store
Microservices Store Concept on Kubernetes

This Repository continues the work of wdcunha's repository:
https://github.com/wdcunha/mtds-project-microservice

This project consists of the following services:

* Database: used Mysql
* Discovery: used Eureka Service, a Netflix Spring Cloud component that is responsible to handle locations of services, making them visible for the whole group of services;
* Gateway: used the one native from Minikube;
* Messaging: Rabbitmq is used to exchange information between services, that is done horizontally;
* Product-service: microservice developed in java using spring boot, responsible to manage products in its database done in mysql;
* Cart-service: also developed in java using spring boot, service in charge of keep prodcuts and its quantities, as well price;
* Order-service: service receives cart's data after cliente dicided to finish choosing items, also developed in java using spring boot;

All of above items run in a separate container in Minikube.

## Mysql Docker container - how to run it

1) In the root of project there is a file named `mysql.yml` that has docker script to start the container with myslq, so in terminal set it up to the same path ;

2) Run the command below to get it instaciated:

    `docker-compose -f mysql.yml up`

## Accessing mysql in docker container (optional - no need for running)

1) Open a connection to the process running using this command:

    `docker exec -ti numberofprocessgoeshere /bin/sh`

2) Start mysql console just calling `mysql -u root -p root` in the folder above

3) Some mysql commmands:

    * show databases
    * use nameoftable
    * show tables
    * CTRL + D (quit)
    * [list of mysql console commands](http://g2pc1.bu.edu/~qzpeng/manual/MySQL%20Commands.htm)