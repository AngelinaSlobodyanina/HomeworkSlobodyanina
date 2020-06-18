package com.example.demo005.config;

import com.example.demo005.dao.QuestionDaoCSV;
import com.example.demo005.service.TestService;
import com.example.demo005.service.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example")
//@PropertySources("classpath:bundle_en_US.properties")
public class ServiceConfig {
    @Bean
    public TestService testService(QuestionDaoCSV questionDaoCSV) {
        return new TestServiceImpl(questionDaoCSV);
    }


}
