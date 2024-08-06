public class OrderTrackingTest {
    public static void main(String[] args) {
        OrderTracking tracking = new OrderTracking();

        tracking.addOrder(new Order(101, "Pizza"));
        tracking.addOrder(new Order(102, "Burger"));

        tracking.displayOrders();

        tracking.processOrder();
        tracking.displayOrders();
    }
}
