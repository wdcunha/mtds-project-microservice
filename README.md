# MTDS project - Microservice

This project consists of the following services:

* Discovery: used Eureka Service, a Netflix Spring Cloud component that is responsible to handle locations of services, making them visible for the whole group of services;
* Gateway: 
* Messaging: Rabbitmq is used 
* Product-service: microservice developed in java using spring boot
* Order-service: the same product

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
    


