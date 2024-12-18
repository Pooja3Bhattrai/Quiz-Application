package com.example.Quiz.Application.Controller;


import com.example.Quiz.Application.entity.Question;
import com.example.Quiz.Application.services.QuestionServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class QuestionController {


    @Autowired
    QuestionServices questionservices;
    @PostMapping("addquestion")

    public ResponseEntity<String> addQuestion(@RequestBody Question questions){

return questionservices.addQuestion(questions);

    }


@GetMapping("allquestions")

    public ResponseEntity<List<Question>> allQuestions(){
return questionservices.getAllQuestions();
}



@GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionservices.getQuestionByCategory(category);
}








}
