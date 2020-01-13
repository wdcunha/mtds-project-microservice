package mtds.microservices.order.service;

import mtds.microservices.order.config.RabbitMQConfig;
import mtds.microservices.order.model.CartOrder;
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

    @RabbitListener(queues = "${cartqueue.rabbitmq.queue}")
    public void recievedMessage(CartOrder cartOrder) {

        try {

            System.out.println("Recieved Message From RabbitMQ cart queue: " + cartOrder);
            this.orderService.insert(cartOrder);

        } catch (Exception ex) {
            log.error("Error trying to save product in order database. Bypassing message requeue {}", ex);
        }
    }
}
