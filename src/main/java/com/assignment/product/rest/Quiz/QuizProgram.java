package com.assignment.product.rest.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizProgram {
    public static void main(String[] args) {
        // Create quiz questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "Paris", "London", "Berlin", "Rome"));
        questions.add(new Question("Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Saturn"));
        questions.add(new Question("What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"));

        // Shuffle the questions
        Collections.shuffle(questions);

        // Start the quiz
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            Collections.shuffle(options);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your answer (1-4): ");
            int answerIndex = scanner.nextInt();
            if (answerIndex >= 1 && answerIndex <= 4) {
                String selectedOption = options.get(answerIndex - 1);
                if (selectedOption.equals(question.getAnswer())) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            System.out.println();
        }

        // Display final score
        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());

        scanner.close();
    }
}

class Question {
    private String question;
    private String answer;
    private List<String> options;

    public Question(String question, String answer, String option1, String option2, String option3) {
        this.question = question;
        this.answer = answer;
        this.options = new ArrayList<>();
        this.options.add(answer);
        this.options.add(option1);
        this.options.add(option2);
        this.options.add(option3);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getOptions() {
        return options;
    }
}
