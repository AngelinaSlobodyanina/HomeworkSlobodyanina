package org.example.domain;

public class Answers {//for reading from file with IoC
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
