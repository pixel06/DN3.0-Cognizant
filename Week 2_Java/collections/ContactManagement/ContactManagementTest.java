public class ContactManagementTest {
    public static void main(String[] args) {
        ContactManagement management = new ContactManagement();

        Contact c1 = new Contact(1, "Alice", "123-456-7890");
        Contact c2 = new Contact(2, "Bob", "987-654-3210");

        management.addContact(c1);
        management.addContact(c2);

        management.displayContacts();

        management.removeContact(1);
        management.displayContacts();
    }
}
