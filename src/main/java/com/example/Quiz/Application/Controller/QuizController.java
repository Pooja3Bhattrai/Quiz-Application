package com.example.Quiz.Application.Controller;

import com.example.Quiz.Application.entity.Quiz;
import com.example.Quiz.Application.entity.QuizWrapper;
import com.example.Quiz.Application.entity.Submit;
import com.example.Quiz.Application.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class QuizController {
    @Autowired
    QuizService quizservice;




    @PostMapping("/create")

    public ResponseEntity<String> createQuiz(@RequestParam String difficultylevel, @RequestParam int numQ,  @RequestParam String title){
        return quizservice.createQuiz(difficultylevel, numQ,title);
    }
@GetMapping("/get/{id}")
public ResponseEntity<List<QuizWrapper>> getQuiz(@PathVariable Integer id){


        return quizservice.getQuiz(id);
}

@PostMapping("/submit/{id}")
public ResponseEntity<Integer> submit(@PathVariable Integer id,@RequestBody List<Submit> response){



    return quizservice.calculateResult(id,response);

}



}
