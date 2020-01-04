package mtds.microservices.order.controller;

import mtds.microservices.order.dao.OrderDao;
import mtds.microservices.order.model.Order;
import mtds.microservices.order.model.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Order>> listOrders() {
        return new ResponseEntity<>(orderDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestBody OrderDTO orderDTO) {
        Order newOrder = new Order();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        newOrder.setProductName(orderDTO.getProductName());
        newOrder.setQuantity(orderDTO.getQuantity());
        newOrder.setDate(date);
        newOrder.setPrice(orderDTO.getPrice());
        return ResponseEntity.ok(orderDao.save(newOrder));
    }

}
