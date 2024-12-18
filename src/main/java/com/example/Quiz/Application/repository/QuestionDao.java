package com.example.Quiz.Application.repository;

import com.example.Quiz.Application.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;












@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    // QuestionDao class to interact with the database for Question table
    // and perform CRUD operations.
    // It will be automatically implemented by Spring Data JPA.


    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.difficultylevel=:difficultylevel ORDER BY RANDOM() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory( String difficultylevel,  int numq);










}
