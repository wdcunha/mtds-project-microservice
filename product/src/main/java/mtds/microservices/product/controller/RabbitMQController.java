package mtds.microservices.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mtds.microservices.product.model.Product;
import mtds.microservices.product.service.RabbitMQSender;
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

class Response {

    public boolean success;
    public String message;
    public Object data;

    public Response(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}

class ResponseFactory {

    private Response response;

    public ResponseFactory build(Object data) {
        this.response = new Response(true, "Message sent to the RabbitMQ product queue Successfully", data);
        return this;
    }

    public Response getResponse(Object data) {
        return this.response;
    }

    public String serialize() {
        ObjectMapper Obj = new ObjectMapper();

        try {
            return Obj.writeValueAsString(this.response);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
