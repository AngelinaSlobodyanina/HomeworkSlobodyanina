package com.example.demo.config;

import com.example.demo.dao.QuestionDaoCSV;
import com.example.demo.dao.QuestionDaoCsvImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public QuestionDaoCSV questionDaoCSV() {
        return new QuestionDaoCsvImpl();
    }
}
