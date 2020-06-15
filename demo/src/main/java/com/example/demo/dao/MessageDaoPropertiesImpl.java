package com.example.demo.dao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@ConfigurationProperties("application")
public class MessageDaoPropertiesImpl{

    //@Autowired
    private MessageSource messageSource;
    private String localeBundle;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String str) {
        return messageSource.getMessage(str, null, Locale.US);
    }
    public void setLocaleBundle(String path) {
        localeBundle = path;
    }

    public String getLocaleBundle() {
        return localeBundle;
    }

}
