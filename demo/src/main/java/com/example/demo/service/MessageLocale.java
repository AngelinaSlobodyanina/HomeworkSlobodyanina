package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Component
    public class MessageLocale {
    private MessageSource messageSource;
    private java.util.Locale nativeLocale;

    @Autowired
    public MessageLocale(@Value("#{locale.code}") String code, MessageSource messageSource) {
        this.messageSource = messageSource;

        switch (code) {
            case "en":
                //nativeLocale = java.util.Locale.ENGLISH;
                nativeLocale = new java.util.Locale("en", "EN");
                break;
            case "ru":
                nativeLocale = new java.util.Locale("ru", "RU");
                break;
            default:
                throw new RuntimeException("Locale for language " + code + " is not supported");
        }
    }

    public String message(String s, Object... objects) {
        return messageSource.getMessage(s, objects, nativeLocale);
    }

    public String message(String s) {
        return message(s, new Object[0]);
    }
}
