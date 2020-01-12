package mtds.microservices.order.service;

import mtds.microservices.order.model.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${orderqueue.rabbitmq.exchange}")
    private String exchange;

    @Value("${orderqueue.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Order order) {
        rabbitTemplate.convertAndSend(exchange, routingkey, order);
        System.out.println("Msg Sent by Order Rabbitmq = " + order);

    }
}
