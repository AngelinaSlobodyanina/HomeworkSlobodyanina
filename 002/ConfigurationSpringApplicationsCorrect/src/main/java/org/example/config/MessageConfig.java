package org.example.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class MessageConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        //messageSource.setBasename("/i18n/src/main/resources/bundle_en_US.properties");
        messageSource.setBasename("/i18n/messages_en_US.properties");
        messageSource.setDefaultEncoding("UTF-8");
        //Locale.setDefault(Locale.ENGLISH);
        return messageSource;
    }
}
