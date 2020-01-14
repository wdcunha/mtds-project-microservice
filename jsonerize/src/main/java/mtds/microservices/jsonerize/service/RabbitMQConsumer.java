package mtds.microservices.jsonerize.service;

import mtds.microservices.jsonerize.config.RabbitMQConfig;
import mtds.microservices.jsonerize.model.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQConsumer {

    @Autowired
    JsonerizeService jsonerizeService;

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @RabbitListener(queues = "${productqueue.rabbitmq.queue}")
    public void recievedMessage(List<ProductDTO> allProducts) {
        System.out.println("Recieved Message From RabbitMQ product queue: " + allProducts);

        try {

            this.jsonerizeService.saveJson(allProducts);

        } catch (Exception ex) {
            log.error("Error trying to save product in cart database. Bypassing message requeue {}", ex);
        }
    }
}
