package com.example.demo.config;

import com.example.demo.dao.MessageDaoPropertiesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class MessageConfig {
    @Bean
    @Autowired
    public MessageSource messageSource(MessageDaoPropertiesImpl messageProperties) {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        String baseName = messageProperties.getLocaleBundle();
        messageSource.setBasename(baseName);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}