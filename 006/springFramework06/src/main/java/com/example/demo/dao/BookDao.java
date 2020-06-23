package com.example.demo.dao;

import com.example.demo.domain.Book;

import java.util.List;

public interface BookDao {
    int count();

    void insert(Book book);

    Book getById(int id);

    List<Book> findAll();

    void deleteById(int id);
}
