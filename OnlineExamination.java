import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int answer;

    public Question(String questionText, String[] options, int answer) {
        this.questionText = questionText;
        this.options = options;
        this.answer = answer;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == answer;
    }
}

public class OnlineExamination {
    private List<Question> questions;
    private int score;

    public OnlineExamination() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Paris", "3. Madrid", "4. Rome"}, 2));
        questions.add(new Question("What is 5 + 7?", new String[]{"1. 10", "2. 11", "3. 12", "4. 13"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Venus", "3. Mars", "4. Jupiter"}, 3));
        // Add more questions as needed
    }

    public void startExam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Examination!");
        System.out.println("You will be presented with multiple-choice questions.\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Enter the number of your answer: ");
            int userAnswer = scanner.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was: " + q.options[q.answer - 1] + "\n");
            }
        }

        System.out.println("Exam completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        OnlineExamination exam = new OnlineExamination();
        exam.startExam();
    }
}
