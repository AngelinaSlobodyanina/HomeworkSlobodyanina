package com.example.demo.dao;

import com.example.demo.domain.Genre;

import java.util.List;

public interface GenreDao {

    void insert(Genre genre);

    Genre getById(Integer id);

    Genre getByTitle(String title);

    List<Genre> findAll();
}
