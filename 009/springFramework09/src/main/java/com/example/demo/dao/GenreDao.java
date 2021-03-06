package com.example.demo.dao;

import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;

import java.util.List;

public interface GenreDao {
    Genre add(String title) throws Exception;
    long getCount();
    List<Genre> getAll(int page, int amountByOnePage);
    Genre findById(long id) throws Exception;
    List<Genre> find(String title) throws Exception;
    List<Book> getBooks(long id);
    Genre update(long id, String title) throws Exception;
    void delete(long id) throws Exception;
    void delete(long id, boolean withBook) throws Exception;
    void deleteAll();
}
