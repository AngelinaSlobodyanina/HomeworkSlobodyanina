package org.example.service;

import java.util.List;


public interface PersonService {
    //comparison correct answers with answers, that given us person
    List<String> comparison(List<String> correctAnswer, List<String> personAnswer);

    //count points
    int score(List<String> result);

}
