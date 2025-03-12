import java.util.HashMap;
import java.util.Scanner;

public class AuthService {
    private HashMap<String, User> users;
    private User loggedInUser;

    public AuthService() {
        users = new HashMap<>();
        users.put("admin", new User("admin", "admin123")); // Default user
    }

    public User login() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to (1) Login or (2) Register?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 2) {
            register();
        }

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).checkPassword(password)) {
            loggedInUser = users.get(username);
            System.out.println("Login Successful! Welcome, " + username);
            return loggedInUser;
        } else {
            System.out.println("Invalid credentials. Try again.");
            return null;
        }
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Username: ");
        String newUsername = scanner.nextLine();

        if (users.containsKey(newUsername)) {
            System.out.println("Username already exists! Try logging in.");
            return;
        }

        System.out.print("Enter new Password: ");
        String newPassword = scanner.nextLine();

        users.put(newUsername, new User(newUsername, newPassword));
        System.out.println("Registration successful! You can now log in.");
    }

    public void logout() {
        System.out.println("Logging out...");
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}

