import java.util.Hashtable;

public class ContactManagement {
    private Hashtable<Integer, Contact> contacts;

    public ContactManagement() {
        contacts = new Hashtable<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
        System.out.println("Contact added: " + contact);
    }

    public void removeContact(int contactId) {
        Contact removedContact = contacts.remove(contactId);
        if (removedContact != null) {
            System.out.println("Contact removed: " + removedContact);
        } else {
            System.out.println("Contact with ID " + contactId + " not found.");
        }
    }

    public void displayContacts() {
        System.out.println("Contacts:");
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }
}
