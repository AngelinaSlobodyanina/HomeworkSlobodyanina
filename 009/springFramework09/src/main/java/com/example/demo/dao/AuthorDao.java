package com.example.demo.dao;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

import java.util.List;

public interface AuthorDao {

    Author add(String name) throws Exception;

    long getCount();

    List<Author> getAll(int page, int amountByOnePage);

    Author findById(long id) throws Exception;

    List<Author> find(String name) throws Exception;

    List<Book> getBooks(long id);

    Author update(long id, String name) throws Exception;

    void delete(long id) throws Exception;

    void delete(long id, boolean withBook) throws Exception;

    void deleteAll();
}