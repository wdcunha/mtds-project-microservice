package mtds.microservices.cart.model;

public class CartOrder {

    private Double amount;

    public CartOrder() {
    }

    public CartOrder(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartOrder{" +
                "amount=" + amount +
                '}';
    }
}
