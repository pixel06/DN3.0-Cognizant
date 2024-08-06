public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNumber;
    }
}
