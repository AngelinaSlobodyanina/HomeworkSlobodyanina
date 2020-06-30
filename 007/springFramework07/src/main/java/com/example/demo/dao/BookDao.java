package com.example.demo.dao;

import com.example.demo.domain.Book;

import java.util.List;

public interface BookDao {

    void insert(Book book);

    Book getById(Integer id);

    Book getByTitle(String title);

    Book getByCode(String code);

    List<Book> findAll();

}
