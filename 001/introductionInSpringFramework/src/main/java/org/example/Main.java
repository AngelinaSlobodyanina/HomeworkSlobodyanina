package org.example;

import org.example.dao.AnswerDao;
import org.example.service.PersonService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Main {

    private static String fileDataCsv = "src/main/resources/data.csv";
    private static String delimiter = ";";
    private static String fileAnswerCsv = "src/main/resources/answer.csv";

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        AnswerDao answerDao = context.getBean(AnswerDao.class);
        PersonService personService = context.getBean(PersonService.class);

        System.out.println("Введите своё имя и фамилию");
        String name = answerDao.Person();

        answerDao.ReadFileDataCSV(fileDataCsv, delimiter);

        System.out.println("\n\nНапишите каждый свой вариант ответа с новой строки, затем нажмите Enter");

        List<String> personAnswerList = answerDao.PersonAnswers();

        List<String> answerList = answerDao.ReadFileAnswerCSV(fileAnswerCsv, delimiter);

        List<String> result = personService.comparison(answerList, personAnswerList);
        int score = personService.score(result);
        System.out.println(name);
        System.out.println("Вы набрали " + score + " баллов из 100");

        System.out.println("Ваши ответы:  " + personAnswerList);


        System.out.println("Правильные ответы: " + answerList);

    }
}
