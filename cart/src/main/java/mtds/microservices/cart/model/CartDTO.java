package mtds.microservices.cart.model;

import java.util.Date;

public class CartDTO {

    private int quantity;
    private Date date;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
