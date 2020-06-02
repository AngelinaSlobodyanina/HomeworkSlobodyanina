package org.example.service;

import org.example.domain.Answers;
import org.example.domain.Questions;

import java.util.List;

public interface PersonService {
    List<String> Comparison(List<String> correctAnswer, List<String> personAnswer );
}
