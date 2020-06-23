package com.example.demo.dao;

import com.example.demo.domain.Genre;

import java.util.List;

public interface GenreDao {
    int count();

    void insert(Genre genre);

    Genre getById(int id);

    List<Genre> findAll();

    void deleteById(int id);
}
