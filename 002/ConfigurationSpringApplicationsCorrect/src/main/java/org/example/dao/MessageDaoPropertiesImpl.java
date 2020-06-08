package org.example.dao;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Repository("messageSource")
public class MessageDaoPropertiesImpl implements MessageSourceAware {

    //@Autowired
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String str) {
        return messageSource.getMessage(str, null, Locale.US);
    }

}