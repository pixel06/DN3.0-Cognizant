package ContactManagementSystem;

import java.io.Serializable;

public class Contact implements Serializable {

    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;

    }

    public String getName()
    {
        return name;
    }
    public String getPhoneno()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhoneno(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override

    public String toString()
    {
        return "name : " + name + ", phno: " + phone + ", email: " + email;
    }



    
}
