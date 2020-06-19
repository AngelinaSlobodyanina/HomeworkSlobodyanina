package com.example.demo005.controller;

import com.example.demo005.domain.Person;
import com.example.demo005.domain.Question;
import com.example.demo005.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
//import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class ShellController {
    @Autowired
    private TestService testService;
    //private MessageLocale messageLocale;


    private static final String CSV_FILE_NAME = "src/main/resources/data.csv";
    private static final String DELIMITER = ";";

    @ShellMethod(value = "Add two integers together.", group = "Mathematical Commands")
    public int add(int a, int b) {
        return a + b;
    }
    @ShellMethod(key = "runTest", value = "Work all programme")
    public void runATest() {
        List<Question> questions = testService.getQuestions(CSV_FILE_NAME, DELIMITER);
        int questionsCount = 0;
        if (questions != null) {
            questionsCount = questions.size();
        }
        Person person = testService.createPerson();
        int score = testService.doTest(person, questions);
        testService.printTestResult(person, score, questionsCount);


    }
}