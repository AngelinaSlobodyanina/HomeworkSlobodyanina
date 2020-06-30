package com.example.demo.dao;
import com.example.demo.domain.Author;
import java.util.List;

public interface AuthorDao {

    void insert(Author author);

    Author getById(Integer id);

    Author getByName(String name);

    List<Author> findAll();

}
