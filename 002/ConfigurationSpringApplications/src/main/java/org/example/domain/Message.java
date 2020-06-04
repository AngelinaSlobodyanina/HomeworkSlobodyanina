package org.example.domain;

import org.springframework.beans.factory.annotation.Value;

public class Message {

    @Value("${message.question1}")
    private String question1;

    public String getQuestion1() {
        return question1;
    }

    @Value("${message.question2}")
    private String question2;

    public String getQuestion2() {
        return question2;
    }

    @Value("${message.question3}")

    private String question3;

    public String getQuestion3() {
        return question3;
    }

    @Value("${message.question4}")
    private String question4;

    public String getQuestion4() {
        return question4;
    }

    @Value("${message.question5}")
    private String question5;

    public String getQuestion5() {
        return question5;
    }

    @Value("${message.question6}")
    private String question6;

    public String getQuestion6() {
        return question6;
    }
}
