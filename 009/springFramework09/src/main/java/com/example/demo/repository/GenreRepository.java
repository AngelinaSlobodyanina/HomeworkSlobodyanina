package com.example.demo.repository;

import  com.example.demo.domain.Book;
import  com.example.demo.domain.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {

    @Query("select b from Book b left join b.genre g where g.id = ?1")
    Iterable<Book> getBooksByID(long id);

    Iterable<Genre> findByTitle(String title);
}