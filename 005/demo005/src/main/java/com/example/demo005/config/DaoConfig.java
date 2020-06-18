package com.example.demo005.config;

import com.example.demo005.dao.MessageDaoPropertiesImpl;
import com.example.demo005.dao.QuestionDaoCSV;
import com.example.demo005.dao.QuestionDaoCsvImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public QuestionDaoCSV questionDaoCSV() {
        return new QuestionDaoCsvImpl();
    }
    @Bean
    public MessageDaoPropertiesImpl messageDaoProperties() {
        return new MessageDaoPropertiesImpl();
    }
}
