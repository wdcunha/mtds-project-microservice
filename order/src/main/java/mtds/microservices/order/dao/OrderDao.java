package mtds.microservices.order.dao;

import mtds.microservices.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {
    Order findTopByOrderByIdDesc();
}
