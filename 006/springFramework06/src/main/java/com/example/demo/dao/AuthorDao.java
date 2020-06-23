package com.example.demo.dao;
import com.example.demo.domain.Author;
import java.util.List;

public interface AuthorDao {
    int count();

    void insert(Author author);

    Author getById(int id);

    List<Author> findAll();

    void deleteById(int id);
}
