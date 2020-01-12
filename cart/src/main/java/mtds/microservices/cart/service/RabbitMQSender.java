package mtds.microservices.cart.service;

import mtds.microservices.cart.model.Cart;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${cartqueue.rabbitmq.exchange}")
    private String exchange;

    @Value("${cartqueue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Cart cart) {
        rabbitTemplate.convertAndSend(exchange, routingkey, cart);
        System.out.println("Cart Rabbitmq Sent msg = " + cart);

    }}
