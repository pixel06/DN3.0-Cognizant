
public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
