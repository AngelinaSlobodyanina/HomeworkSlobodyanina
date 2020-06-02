package org.example.service;

import org.example.domain.Answers;
import org.example.domain.Questions;

import java.io.IOException;
import java.util.List;

public interface PersonService {

    List<String> comparison(List<String> correctAnswer, List<String> personAnswer );
    List<String> readFileAnswerCSV(String fileName, String delimiter) throws IOException;
}
