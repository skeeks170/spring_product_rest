package com.assignment.product.rest.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository repository;

    public Quiz addQuizQuestion(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> getAllQuizQuestions() {
        return repository.findAll();
    }

    public Optional<Quiz> getQuizQuestionById(int questionId) {
        return repository.findById(questionId);
    }

    public String deleteQuizQuestionById(int questionId) {
        repository.deleteById(questionId);
        return "Question has been deleted";
    }

    public Quiz updateQuizQuestion(int questionId, Quiz quiz) {
        Quiz existingQuiz = repository.findById(questionId).orElse(null);
        if (existingQuiz != null) {
            existingQuiz.setQuestion(quiz.getQuestion());
            existingQuiz.setOptionAnswer(quiz.getOptionAnswer());
            existingQuiz.setOption2(quiz.getOption2());
            existingQuiz.setOption3(quiz.getOption3());
            existingQuiz.setOption4(quiz.getOption4());
            existingQuiz.setCategory(quiz.getCategory());
            return repository.save(existingQuiz);
        }
        return null;
    }

    public List<Quiz> getQuizQuestionsByCategory(String category) {
        return repository.findByCategory(category);
    }
}
