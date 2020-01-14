package mtds.microservices.jsonerize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "mtds.microservices.jsonerize")
@EntityScan("mtds.microservices.cart.model")
public class JsonerizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonerizeApplication.class, args);
    }

}

