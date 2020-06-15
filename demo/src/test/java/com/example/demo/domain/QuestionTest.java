package com.example.demo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void getQuestionText() {
        String expectedQuestionText = "String";
        List<String> answers = new ArrayList<>();
        Question question = new Question(1,expectedQuestionText,answers,0);
        Assertions.assertEquals(expectedQuestionText,question.getQuestionText());
    }

    @Test
    void getAnswers() {
        List<String> expectedAnswers = new ArrayList<>();
        Question question = new Question(1,"string",expectedAnswers,0);
        Assertions.assertEquals(expectedAnswers,question.getAnswers());
    }

    @Test
    void getCorrectAnswerIndex() {
        int expectedCorrectAnswerIndex = 0;
        List<String> answers = new ArrayList<>();
        Question question = new Question(1,"string",answers,expectedCorrectAnswerIndex);
        Assertions.assertEquals(expectedCorrectAnswerIndex,question.getCorrectAnswerIndex());
    }

    @Test
    void getQuestionNumber() {
        int expectedQuestionNumber = 0;
        List<String> answers = new ArrayList<>();
        Question question = new Question(expectedQuestionNumber,"string",answers,0);
        Assertions.assertEquals(expectedQuestionNumber,question.getQuestionNumber());
    }
}