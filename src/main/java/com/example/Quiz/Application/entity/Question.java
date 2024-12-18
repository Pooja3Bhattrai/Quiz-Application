package com.example.Quiz.Application.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "question")
public class Question {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;
    private String language;

    private String status;
    private String remarks;



}
