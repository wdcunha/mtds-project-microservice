package mtds.microservices.cart;

import mtds.microservices.cart.dao.CartDao;
import mtds.microservices.cart.model.Cart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@EntityScan("mtds.microservices.cart.model")
@EnableJpaRepositories("mtds.microservices.cart.dao")
public class CartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }

}

