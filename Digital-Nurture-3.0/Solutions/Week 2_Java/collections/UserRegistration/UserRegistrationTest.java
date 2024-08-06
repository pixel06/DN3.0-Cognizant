public class UserRegistrationTest {
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        registration.registerUser("Alice");
        registration.registerUser("Bob");
        registration.registerUser("Charlie");

        registration.displayUsers();

        registration.removeUser("Bob");
        registration.displayUsers();
    }
}
