package mtds.microservices.product;

import mtds.microservices.product.dao.ProductDao;
import mtds.microservices.product.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("mtds.microservices.product.model")
@EnableJpaRepositories("mtds.microservices.product.dao")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductDao productDao) {
        return args -> {
            productDao.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100"));
            productDao.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100"));
            productDao.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100"));
            productDao.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100"));
            productDao.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100"));
            productDao.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100"));
            productDao.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100"));
        };
    }

}

