package com.example.Quiz.Application.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data

//but in data all args is not included

public class QuizWrapper {
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuizWrapper(Integer id,String questionTitle,String option1,String option2,String option3,String option4) {
this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

}
