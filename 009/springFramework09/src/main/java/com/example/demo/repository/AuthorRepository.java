package com.example.demo.repository;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository  extends PagingAndSortingRepository<Author, Long> {
    @Query("select b from Book b left join b.authors a where a.id = ?1")
    Iterable<Book> getBooksByID(long id);

    Iterable<Author> findByName(String name);
}
