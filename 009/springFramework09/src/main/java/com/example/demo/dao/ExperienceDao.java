package com.example.demo.dao;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Experience;


import java.util.List;

public interface ExperienceDao {

    Experience add(int years, String place) throws Exception;
    long getCount();
    List<Experience> getAll(int page, int amountByOnePage);
    Experience findById(long id) throws Exception;
    List<Experience> find(String place) throws Exception;
    List<Author> getAuthors(long id);
    Experience update(long id, String place) throws Exception;
    void deleteAll();

}
