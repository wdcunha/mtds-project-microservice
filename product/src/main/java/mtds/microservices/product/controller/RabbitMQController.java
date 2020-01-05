package mtds.microservices.product.controller;

import mtds.microservices.product.model.Product;
import mtds.microservices.product.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-rabbitmq/")
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("productName") String productName, @RequestParam("price") Double price) {

        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        rabbitMQSender.send(product);

        return "Message sent to the RabbitMQ productqueue Successfully";
    }
}
