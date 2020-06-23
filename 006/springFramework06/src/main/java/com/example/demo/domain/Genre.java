package com.example.demo.domain;

public class Genre {
    private final Integer id;
    private final String title;

    public Genre(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
