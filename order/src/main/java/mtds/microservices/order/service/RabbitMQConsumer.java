package mtds.microservices.order.service;

import mtds.microservices.order.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @Autowired
    OrderService orderService;

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @RabbitListener(queues = "${orderqueue.rabbitmq.queue}")
    public void recievedMessage(String amount) {
        System.out.println("Recieved Message From RabbitMQ cart queue: " + amount);

        try {

            this.orderService.insert(amount);

        } catch (Exception ex) {
            log.error("Error trying to save product in order database. Bypassing message requeue {}", ex);
        }
    }
}
