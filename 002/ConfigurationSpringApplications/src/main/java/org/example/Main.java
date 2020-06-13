package org.example;


import org.example.config.ServiceConfig;
import org.example.dao.AnswerDao;
import org.example.domain.Message;
import org.example.service.PersonService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {

    private static String fileDataCsv = "src/main/resources/data.csv";
    private static String delimiter = ";";
    private static String fileAnswerCsv = "src/main/resources/answer.csv";

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

        AnswerDao answerDao = context.getBean(AnswerDao.class);
        PersonService personService = context.getBean(PersonService.class);
        Message message = context.getBean(Message.class);

        System.out.println(message.getQuestion1());
        String name = answerDao.Person();

        answerDao.ReadFileDataCSV(fileDataCsv, delimiter);

        System.out.println("\n\n" + message.getQuestion2());

        List<String> personAnswerList = answerDao.PersonAnswers();

        List<String> answerList = answerDao.ReadFileAnswerCSV(fileAnswerCsv, delimiter);

        List<String> result = personService.comparison(answerList, personAnswerList);
        int score = personService.score(result);
        System.out.println(name);
        System.out.println(message.getQuestion3() + "  " + score + "  " + message.getQuestion4());

        System.out.println(message.getQuestion5() + "  " + personAnswerList);


        System.out.println(message.getQuestion6() + "  " + answerList);

        context.close();
    }
}
