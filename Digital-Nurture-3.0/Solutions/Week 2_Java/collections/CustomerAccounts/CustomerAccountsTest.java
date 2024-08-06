public class CustomerAccountsTest {
    public static void main(String[] args) {
        CustomerAccounts accounts = new CustomerAccounts();

        Customer c1 = new Customer(101, "Alice", "alice@example.com");
        Customer c2 = new Customer(102, "Bob", "bob@example.com");

        accounts.addCustomer(c1);
        accounts.addCustomer(c2);

        accounts.displayCustomers();

        accounts.removeCustomer(101);
        accounts.displayCustomers();
    }
}
