package com.example.demo005.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;

import static org.mockito.Mockito.*;

class MessageLocaleTest {

    @Test
    public void expectedMessageCall() {
        String testedString = "Some string {change}";

        MessageSource mock = mock(MessageSource.class);
        MessageLocale locale = new MessageLocale("en", mock);
        Object[] replaceArgs = {"replace"};
        locale.message(testedString, replaceArgs);
        verify(mock, times(1)).getMessage(eq(testedString), eq(replaceArgs), eq(java.util.Locale.ENGLISH));
    }

    @Test
    public void shortMessageCall() {
        String testedString = "Some string {change}";

        MessageSource mock = mock(MessageSource.class);
        MessageLocale locale = new MessageLocale("ru", mock);
        locale.message(testedString);

        verify(mock, times(1)).getMessage(eq(testedString), eq(new Object[0]), any());
    }

    @Test
    public void wrongLanguageCode() {
        new MessageLocale("zero", mock(MessageSource.class));
    }
}