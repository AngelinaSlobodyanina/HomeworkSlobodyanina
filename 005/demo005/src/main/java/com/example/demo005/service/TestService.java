package com.example.demo005.service;

import com.example.demo005.domain.Person;
import com.example.demo005.domain.Question;

import java.util.List;
import java.util.Locale;

public interface TestService {

    List<Question> getQuestions(String fileName, String delimiter);

    Person createPerson();

    int doTest(Person person, List<Question> questions);

    void printTestResult(Person person, int score, int questionsCount);

    //Locale whatTheLocale();
}