package org.example.service;

import org.example.domain.Answers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private Answers answers;

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
    public PersonServiceImpl(Answers answers) {
        this.answers = answers;
    }

    public PersonServiceImpl() {}

    public List<String> Comparison(List<String> correctAnswer, List<String> personAnswer) {
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