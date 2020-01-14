package mtds.microservices.order.service;

import mtds.microservices.order.dao.OrderDao;
import mtds.microservices.order.model.CartOrder;
import mtds.microservices.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
@Configurable
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Order insert(CartOrder cartOrder) {
        Order newCart = new Order();
        Date date = Calendar.getInstance().getTime();

        newCart.setAmount(cartOrder.getAmount());
        newCart.setDate(date);

        return this.orderDao.save(newCart);
    }


}
