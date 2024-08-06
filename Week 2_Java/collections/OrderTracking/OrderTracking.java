import java.util.LinkedList;

public class OrderTracking {
    private LinkedList<Order> orders;

    public OrderTracking() {
        orders = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added: " + order);
    }

    public Order processOrder() {
        Order order = orders.poll();
        if (order != null) {
            System.out.println("Order processed: " + order);
        } else {
            System.out.println("No orders to process.");
        }
        return order;
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
