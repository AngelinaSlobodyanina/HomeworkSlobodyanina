package org.example.config;


import org.example.dao.AnswerDaoSimple;
import org.example.domain.Answers;
import org.example.domain.Questions;
import org.example.service.PersonServiceImpl;
import org.example.domain.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Spring create  configuration
@Configuration
@PropertySource("classpath:bundle_ru_Ru.properties")
public class ServiceConfig {
    //Creat four variables
    @Bean
    public Answers correctAnswers() {
        return new Answers();
    }

    @Bean
    public Questions questions() {
        return new Questions();
    }

    @Bean
    public PersonServiceImpl personServiceImpl() {
        return new PersonServiceImpl();
    }

    @Bean
    public AnswerDaoSimple answerDaoSimple() {
        return new AnswerDaoSimple();
    }
    @Bean
    public Message message() {
        return new Message() ;
    }
}

