package org.example.config;

import org.example.dao.QuestionDao;
import org.example.service.TestService;
import org.example.service.TestServiceImpl;
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
