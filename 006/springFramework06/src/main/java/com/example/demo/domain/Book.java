package com.example.demo.domain;

public class Book {
    private final Integer id;
    private final String title;
    private final String code;

    public Book(Integer id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code =code;
    }

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCode() {
        return code;
    }
}
