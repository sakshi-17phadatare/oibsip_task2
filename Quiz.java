import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;
    private boolean isSessionActive;

    public Quiz() {
        questions = new ArrayList<>();
        loadQuestions();
        score = 0;
        isSessionActive = true;
    }

    private void loadQuestions() {
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2));
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3));
        questions.add(new Question("Java is a ___ language.", new String[]{"Low-level", "Assembly", "High-level", "Machine"}, 3));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question q : questions) {
            if (!isSessionActive) break; // Stop quiz if session closed

            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            if (q.checkAnswer(answer)) {
                score += 10;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong Answer!\n");
            }
        }

        System.out.println("Quiz Over! Your Score: " + score);
    }

    public void closeSession() {
        isSessionActive = false;
        System.out.println("Session closed.");
    }
}

