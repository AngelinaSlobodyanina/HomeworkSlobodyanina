package org.example.domain;


import org.springframework.beans.factory.annotation.Value;


public class Questions {//read all values from data.csv file


   @Value("${data.csv}")
    private String question, answer1, answer2, answer3, answer4;

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer3(String answer1) {
        this.answer3 = answer3;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer4() {
        return answer4;
    }

    @Override
    public String toString() {
        return "\n\n" + getQuestion() + "  " + getAnswer1() + "  " + getAnswer2()
                + "  " + getAnswer3() + "  " + getAnswer4();
    }
}