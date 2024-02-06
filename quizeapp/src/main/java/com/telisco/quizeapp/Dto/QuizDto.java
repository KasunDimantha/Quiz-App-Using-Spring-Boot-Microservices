package com.telisco.quizeapp.Dto;

import com.telisco.quizeapp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDto extends JpaRepository<Quiz, Integer> {

}
