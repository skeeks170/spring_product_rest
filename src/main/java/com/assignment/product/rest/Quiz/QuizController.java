package com.assignment.product.rest.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("/addQuestionToDB")
    public Quiz addQuizQuestion(@RequestBody Quiz quiz) {
        return service.addQuizQuestion(quiz);
    }

    @GetMapping("/quizQuestions")
    public List<Quiz> getAllQuizQuestions() {
        return service.getAllQuizQuestions();
    }

    @GetMapping("/question/{questionId}")
    public Optional<Quiz> getQuizQuestionById(@PathVariable int questionId) {
        return service.getQuizQuestionById(questionId);
    }

    @DeleteMapping("/deleteQuestion/{questionId}")
    public String deleteQuizQuestionById(@PathVariable int questionId) {
        return service.deleteQuizQuestionById(questionId);
    }

    @PutMapping("/question/{questionId}")
    public Quiz updateQuizQuestion(@PathVariable int questionId, @RequestBody Quiz quiz) {
        return service.updateQuizQuestion(questionId, quiz);
    }

    @GetMapping("/questions/{category}")
    public List<Quiz> getQuizQuestionsByCategory(@PathVariable String category) {
        return service.getQuizQuestionsByCategory(category);
    }

    @PostMapping("/submit")
    public int submitAnswers(@RequestBody List<Quiz> answers, @RequestParam String userName) {
        int score = 0;
        for (Quiz answer : answers) {
            Optional<Quiz> question = service.getQuizQuestionById(answer.getId());
            if (question.isPresent()) {
                Quiz quiz = question.get();
                if (answer.getOptionAnswer().equals(quiz.getOptionAnswer())) {
                    score++;
                }
            }
        }
        return score;
    }
}
