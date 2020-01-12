package mtds.microservices.order.service;

import mtds.microservices.order.dao.OrderDao;
import mtds.microservices.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Configurable
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Order insert(String amount) {
        Order newCart = new Order();
        Date date = Calendar.getInstance().getTime();

        newCart.setAmount(Double.parseDouble(amount));
        newCart.setDate(date);

        return this.orderDao.save(newCart);
    }

}
