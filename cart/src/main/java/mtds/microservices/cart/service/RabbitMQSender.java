package mtds.microservices.cart.service;

import mtds.microservices.cart.model.CartOrder;
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

    public void send(CartOrder cartOrder) {
        rabbitTemplate.convertAndSend(exchange, routingkey, cartOrder);
        System.out.println("Cart Rabbitmq Sent msg to Order = " + cartOrder);

    }
}
