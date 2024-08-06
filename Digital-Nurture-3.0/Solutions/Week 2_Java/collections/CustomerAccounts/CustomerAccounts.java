import java.util.TreeMap;

public class CustomerAccounts {
    private TreeMap<Integer, Customer> customers;

    public CustomerAccounts() {
        customers = new TreeMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        System.out.println("Customer added: " + customer);
    }

    public void removeCustomer(int customerId) {
        Customer removedCustomer = customers.remove(customerId);
        if (removedCustomer != null) {
            System.out.println("Customer removed: " + removedCustomer);
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }

    public void displayCustomers() {
        System.out.println("Customer Accounts:");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }
}
