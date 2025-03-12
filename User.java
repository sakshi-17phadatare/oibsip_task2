import java.util.Scanner;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void updateProfile(String newUsername) {
        this.username = newUsername;
        System.out.println("Profile updated successfully.");
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Incorrect old password!");
        }
    }
}

