package mtds.microservices.cart.controller;

import mtds.microservices.cart.model.CartOrder;
import mtds.microservices.cart.service.RabbitMQSender;
import mtds.microservices.cart.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @CrossOrigin
    @GetMapping(value = "/producer")
    public String producer(@RequestParam("amount") String amount) {

        CartOrder cartOrder = new CartOrder();
        cartOrder.setAmmount(Double.parseDouble(amount));
        rabbitMQSender.send(cartOrder);

        return new ResponseFactory().build(cartOrder).serialize();
    }
}
