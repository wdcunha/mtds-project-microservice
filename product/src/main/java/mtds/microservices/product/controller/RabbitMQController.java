package mtds.microservices.product.controller;

import mtds.microservices.product.model.Product;
import mtds.microservices.product.service.RabbitMQSender;
import mtds.microservices.product.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @CrossOrigin
    @PostMapping(value = "/producer")
    public String producer(@RequestBody List<Product> productsList) {

        rabbitMQSender.send(productsList);

        return new ResponseFactory().build(productsList).serialize();
    }
}
