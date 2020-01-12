package mtds.microservices.cart.service;

import mtds.microservices.cart.config.RabbitMQConfig;
import mtds.microservices.cart.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQConsumer {

    @Autowired
    CartService cartService;

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @RabbitListener(queues = "${productqueue.rabbitmq.queue}")
    public void recievedMessage(List<Product> selectedProducts) {
        System.out.println("Recieved Message From RabbitMQ product queue: " + selectedProducts);

        try {

            this.cartService.insert(selectedProducts);

        } catch (Exception ex) {
            log.error("Error trying to save product in cart database. Bypassing message requeue {}", ex);
        }
    }
}
