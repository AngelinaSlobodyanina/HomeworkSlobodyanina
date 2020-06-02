package org.example;

import org.example.dao.AnswerDao;
import org.example.dao.AnswerDaoSimple;
import org.example.domain.Answers;
import org.example.domain.Questions;
import org.example.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String fileDataCsv = "src/main/resources/data.csv";
    private static String delimiter = ";";
    private static String fileAnswerCsv = "src/main/resources/data.csv";
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnswerDao answerDao = context.getBean(AnswerDao.class);


        answerDao.ReadFileDataCSV(fileDataCsv,delimiter);
    }
}
