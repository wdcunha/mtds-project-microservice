package mtds.microservices.cart.service;

import mtds.microservices.cart.dao.CartDao;
import mtds.microservices.cart.model.Cart;
import mtds.microservices.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Configurable
public class CartService {

    @Autowired
    CartDao cartDao;

    public Cart insert(List<Product> productList) {
        Cart newCart = new Cart();
        Date date = Calendar.getInstance().getTime();

        newCart.setProductsList(productList);
        newCart.setDate(date);

        newCart.getProductsList()
                .forEach(x -> {
                    x.setCart(newCart);
                    x.setQuantity(1);
                });

        return this.cartDao.save(newCart);
    }

}
