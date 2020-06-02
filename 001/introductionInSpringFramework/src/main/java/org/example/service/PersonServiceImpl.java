package org.example.service;

import org.example.dao.AnswerDao;
import org.example.domain.Answers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private AnswerDao answerDao;


    public PersonServiceImpl() {}

    public PersonServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }


    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public List<String> readFileAnswerCSV(String fileName, String delimiter) throws IOException {

        return answerDao.ReadFileAnswerCSV(fileName, delimiter);
    }

    public List<String> comparison(List<String> correctAnswer, List<String> personAnswer) {
        Iterator<String> corAnswer = correctAnswer.iterator();
        Iterator<String> perAnswer = personAnswer.iterator();
        List<String> result = new ArrayList<>();
        while (corAnswer.hasNext()){
            if (corAnswer.hasNext() == perAnswer.hasNext()) result.add("true");
            else result.add("false");
        }
        return result;
    }

}