package mtds.microservices.product.service;

import mtds.microservices.product.model.Product;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${productqueue.rabbitmq.exchange}")
    private String exchange;

    @Value("${productqueue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(List<Product> productsList) {
        rabbitTemplate.convertAndSend(exchange, routingkey, productsList);
        System.out.println("Product Rabbitmq Sent msg = " + productsList);

    }
}
