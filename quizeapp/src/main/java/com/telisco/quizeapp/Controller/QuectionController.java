package com.telisco.quizeapp.Controller;

import com.telisco.quizeapp.Model.Question;
import com.telisco.quizeapp.Service.QuectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Question")
public class QuectionController {

    @Autowired
    private QuectionService quectionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return  quectionService.getAllQuestion();
    }

    @GetMapping("allQuestions/{ID}")
    public  ResponseEntity<Optional<Question>> getAllQuestionsByID(@PathVariable Integer ID){
        return quectionService.getAllQuestionsByID(ID);
    }

    @GetMapping("Category/{category}")
    public List<Question> getAllQuestionByCategory(@PathVariable String category){
        return quectionService.getAllQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
        return quectionService.addQuestion((Question) question);
    }

}
