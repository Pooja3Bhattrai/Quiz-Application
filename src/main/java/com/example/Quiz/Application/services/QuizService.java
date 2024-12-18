package com.example.Quiz.Application.services;

import com.example.Quiz.Application.entity.Question;
import com.example.Quiz.Application.entity.Quiz;
import com.example.Quiz.Application.entity.QuizWrapper;
import com.example.Quiz.Application.entity.Submit;
import com.example.Quiz.Application.repository.QuestionDao;
import com.example.Quiz.Application.repository.QuizDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {

@Autowired
QuizDao quizdao;

@Autowired
QuestionDao questiondao;

public ResponseEntity <String>createQuiz(String difficultylevel, int numQ,String title) {

    List<Question> questions = questiondao.findRandomQuestionsByCategory(difficultylevel, numQ);

    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    quiz.setQuestions(questions);
    quizdao.save(quiz);


return new ResponseEntity<>("success ho gya", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuizWrapper>> getQuiz(int id) {

  Optional<Quiz> quiz = quizdao.findById(id);   //identified quiz by id

    List<Question> questionsfromDB = quiz.get().getQuestions();   //fetched questions from db

  List<QuizWrapper> questionForUser = new ArrayList<>();   //created a list for questions to be sent to user

    for(Question q : questionsfromDB){   //looping through questions
        QuizWrapper qw = new QuizWrapper( q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        questionForUser.add(qw);
    }

return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Submit> response) {

       Quiz quiz = quizdao.findById(id).orElse(null);  //once we get quiz it from quiz database
        List<Question>questions = quiz.getQuestions();  //now we have lists of questions

        int marks = 0;
        int i =0;

        for(Submit s:response){
            if(s.getResponse().equals(questions.get(i).getRightAnswer())){
                marks++;
            }
            i++;
        }
return new ResponseEntity<>(marks, HttpStatus.CREATED);



    }




}
