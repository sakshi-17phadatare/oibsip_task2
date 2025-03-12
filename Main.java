import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        User user = null;
        
        while (user == null) {
            user = authService.login();
        }

        Scanner scanner = new Scanner(System.in);
        SessionManager sessionManager = new SessionManager();
        TimerTaskManager timer = new TimerTaskManager(sessionManager, 30); // 30-sec quiz

        Quiz quiz = new Quiz();
        quiz.startQuiz();

        System.out.println("\nDo you want to update profile? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            System.out.print("Enter new username: ");
            String newUsername = scanner.next();
            user.updateProfile(newUsername);
        }

        System.out.println("\nDo you want to change password? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            System.out.print("Enter old password: ");
            String oldPassword = scanner.next();
            System.out.print("Enter new password: ");
            String newPassword = scanner.next();
            user.updatePassword(oldPassword, newPassword);
        }

        authService.logout();
    }
}
