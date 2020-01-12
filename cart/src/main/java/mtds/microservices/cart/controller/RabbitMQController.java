package mtds.microservices.cart.controller;

import mtds.microservices.cart.model.Cart;
import mtds.microservices.cart.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("productName") String productName, @RequestParam("quantity") String quantity) {

        Cart cart = new Cart();
        rabbitMQSender.send(cart);

        return "Message sent to the RabbitMQ cartqueue Successfully";
    }
}
