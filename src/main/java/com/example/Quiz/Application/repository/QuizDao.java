package com.example.Quiz.Application.repository;

import com.example.Quiz.Application.entity.Question;
import com.example.Quiz.Application.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository <Quiz, Integer>{



   Quiz findById(Quiz id);






   }



