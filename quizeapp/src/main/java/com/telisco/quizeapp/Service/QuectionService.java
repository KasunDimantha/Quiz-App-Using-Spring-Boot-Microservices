package com.telisco.quizeapp.Service;

import com.telisco.quizeapp.Dto.QuectionDto;
import com.telisco.quizeapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuectionService {

    @Autowired
    private QuectionDto quectionDto;
    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(quectionDto.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<Optional<Question>> getAllQuestionsByID(Integer ID) {
        return new ResponseEntity<>(quectionDto.findById(ID), HttpStatus.OK);
    }

    public List<Question> getAllQuestionByCategory(String category) {
        return quectionDto.findByCategory(category);
    }


    public String addQuestion(Question question) {
        quectionDto.save(question);
        return "Sucsess";
    }
}
