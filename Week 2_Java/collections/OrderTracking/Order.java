public class Order {
    private int orderId;
    private String orderDetails;

    public Order(int orderId, String orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Details: " + orderDetails;
    }
}
