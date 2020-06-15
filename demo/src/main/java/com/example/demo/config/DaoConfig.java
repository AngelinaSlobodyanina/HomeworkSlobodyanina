package com.example.demo.onfig;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuestionDaoCsvImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoCsvImpl();
    }
}
