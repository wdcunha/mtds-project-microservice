package mtds.microservices.cart.dao;

import mtds.microservices.cart.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends CrudRepository<Cart, Long> {
    Cart findTopByOrderByIdDesc();
}
