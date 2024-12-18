package com.example.Quiz.Application.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Submit {




    private Integer id;

   String response;

}
