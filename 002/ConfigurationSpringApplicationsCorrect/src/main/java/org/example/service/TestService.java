package org.example.service;

import org.example.domain.Person;
import org.example.domain.Question;
import org.springframework.context.MessageSource;

import java.util.List;

public interface TestService {

    List<Question> getQuestions(String fileName, String delimiter);

    Person createPerson();

    int doTest(Person person, List<Question> questions);

    void printTestResult(Person person, int score, int questionsCount);
}