package com.example.demo.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.dao.DuplicateKeyException;

@NoArgsConstructor(access = AccessLevel.NONE)
public class HandlerException {

    static final String ERROR_STRING = "Операция с объектом %s не выполнена";
    static final String DUPLICATE_ERROR_STRING = "Запись %s существует";
    static final String FORMAT_ERROR_STRING = "Формат поля объекта %s не корректнен";
    static final String EMPTY_RESULT_BY_ID_ERROR_STRING = "Объект %s c id %d не найден";
    static final String ASSOCIATED_ERROR_STRING = "Объект %s не удалить при ссылающего на него %s объектов";

    static void handlerException(Exception exception, String object) throws Exception {
        System.out.println(exception.getClass().getName());
        System.out.println(exception.getMessage());
        if(exception instanceof DuplicateKeyException)
            throw new Exception(String.format(DUPLICATE_ERROR_STRING, object));
        else
            throw new Exception(String.format(ERROR_STRING, object));
    }
} 