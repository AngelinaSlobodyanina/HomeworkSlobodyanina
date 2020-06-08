package org.example;

import org.example.domain.Person;
import org.example.domain.Question;
import org.example.service.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String CSV_FILE_NAME = "src/main/resources/data.csv";
    private static final String DELIMITER = ";";


    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");


        TestService testService = context.getBean(TestService.class);

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
