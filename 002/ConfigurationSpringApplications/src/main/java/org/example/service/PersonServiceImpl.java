package org.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonServiceImpl implements PersonService {


    public PersonServiceImpl() {
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

