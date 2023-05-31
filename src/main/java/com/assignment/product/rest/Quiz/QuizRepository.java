package com.assignment.product.rest.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    List<Quiz> findByCategory(String category);
}
