package OrderProcessing;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Alice", 150.0, "Pending"));
        orders.add(new Order("2", "Bob", 250.0, "Pending"));
        orders.add(new Order("3", "Charlie", 100.0, "Pending"));

        OrderFilter filterByAmount = order -> order.getOrderAmount() > 200;
        OrderProcessor processOrder = order -> order.setStatus("Processed");

        
        filterAndProcessOrders(orders, filterByAmount, processOrder);
    }

    private static void filterAndProcessOrders(List<Order> orders, OrderFilter filter, OrderProcessor processor) {
        for (Order order : orders) {
            if (filter.filter(order)) {
                processor.process(order);
            }
        }
       
        orders.forEach(System.out::println);
    }
}
