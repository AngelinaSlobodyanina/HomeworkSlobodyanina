package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.domain.Question;
import org.springframework.context.MessageSource;

import java.util.List;

public interface TestService {

    List<Question> getQuestions(String fileName, String delimiter);

    Person createPerson();

    int doTest(Person person, List<Question> questions);

    void printTestResult(Person person, int score, int questionsCount);
}