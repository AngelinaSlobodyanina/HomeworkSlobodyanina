package org.example.domain;


import org.springframework.beans.factory.annotation.Value;


public class Answers {//read all values from answer.csv file

    @Value("${answer.csv}")
    private String correctAnswer;

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return getCorrectAnswer();
    }
}
