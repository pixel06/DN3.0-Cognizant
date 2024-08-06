package ContactManagementSystem;

public class ContactApp {
    public static void main(String[] args) {
   
        Contact contact = new Contact("Sohith Penumajji", "90109091019", "spenumaj@cog.com");

        String fileName = "contact.ser";
        ContactWriter contactWriter = new ContactWriter();
        contactWriter.saveContact(fileName, contact);

        
        ContactReader contactReader = new ContactReader();
        Contact readContact = contactReader.readContact(fileName);
        if (readContact != null) {
            System.out.println("Contact read from file: " + readContact);
        }

        
        String nonExistentFile = "non_existent_contact.ser";
        contactReader.readContact(nonExistentFile);
    }
}
