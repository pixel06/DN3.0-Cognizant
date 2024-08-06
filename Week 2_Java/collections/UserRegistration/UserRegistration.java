import java.util.TreeSet;

public class UserRegistration {
    private TreeSet<String> users;

    public UserRegistration() {
        users = new TreeSet<>();
    }

    public void registerUser(String userName) {
        if (users.add(userName)) {
            System.out.println(userName + " registered.");
        } else {
            System.out.println(userName + " already registered.");
        }
    }

    public void removeUser(String userName) {
        if (users.remove(userName)) {
            System.out.println(userName + " removed.");
        } else {
            System.out.println(userName + " not found.");
        }
    }

    public void displayUsers() {
        System.out.println("Registered users:");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
