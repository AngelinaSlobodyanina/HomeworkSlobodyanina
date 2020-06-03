package org.example.service;

import org.example.dao.AnswerDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private AnswerDao answerDao;

    public PersonServiceImpl() {
    }

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
        while (corAnswer.hasNext()) {
            String a = corAnswer.next();
            String b = perAnswer.next();
            if (a.equals(b)) result.add("true");

            else result.add("false");
        }
        return result;
    }

    public int score(List<String> result) {
        Iterator<String> res = result.iterator();
        int score = 0;
        while (res.hasNext()) {
            String a = res.next();
            if (a.equals("true")) score += 20;
        }
        return score;
    }
}

