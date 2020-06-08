package org.example.config;

import org.example.dao.QuestionDao;
import org.example.dao.QuestionDaoCsvImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoCsvImpl();
    }
}
