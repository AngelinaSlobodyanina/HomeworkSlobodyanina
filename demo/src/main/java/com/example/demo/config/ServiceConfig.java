package com.example.demo.config;

import com.example.demo.dao.QuestionDao;
import com.example.demo.service.TestService;
import com.example.demo.service.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.example")
//@PropertySources("classpath:bundle_en_US.properties")
public class ServiceConfig {
    @Bean
    public TestService testService(QuestionDao questionDao) {
        return new TestServiceImpl(questionDao);
    }


}
