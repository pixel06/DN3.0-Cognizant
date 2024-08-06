package ContactManagementSystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ContactWriter {

    public void saveContact(String filename, Contact contact)
    {
        try(FileOutputStream fileout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileout))
            {
                out.writeObject(contact);
                System.out.println("Contact saved to file: " + filename);
            } catch (IOException e) {
            e.printStackTrace();
        }

        

    
    }

    
}
