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

            productDao.save(new Product(1L, "TV Set", 300.00, "http://www.pngmart.com/files/1/TV-Transparent-PNG.png"));
            productDao.save(new Product(2L, "Game Console", 200.00, "http://www.pngall.com/wp-content/uploads/2/Console-PNG-Transparent-HD-Photo.png"));
            productDao.save(new Product(3L, "Sofa", 100.00, "http://www.pngall.com/wp-content/uploads/4/Luxury-Couch-PNG-Free-Image.png"));
            productDao.save(new Product(4L, "Macbook", 900.00, "https://cdn4.iconfinder.com/data/icons/MacBook_Pro/512/leopard.png"));
            productDao.save(new Product(5L, "Iphone", 800.00, "http://www.pngall.com/wp-content/uploads/2016/06/IPhone-PNG-Picture-PNG-Clipart.png"));
            productDao.save(new Product(6L, "Mouse", 30.00, "https://www.iconhot.com/icon/png/apple-products/256/mighty-mouse.png"));
            productDao.save(new Product(7L, "Watch", 30.00, "https://pngimage.net/wp-content/uploads/2018/06/iwatch-png.png"));
            productDao.save(new Product(8L, "Nespresso", 130.00, "https://pngimage.net/wp-content/uploads/2018/06/nespresso-png-8.png"));
            productDao.save(new Product(9L, "ROOMBA", 400.00, "https://pngimage.net/wp-content/uploads/2018/06/irobot-png-4.png"));
        };
    }

}

