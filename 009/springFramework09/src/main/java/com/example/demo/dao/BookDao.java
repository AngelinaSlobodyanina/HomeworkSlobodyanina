package com.example.demo.dao;

import com.example.demo.domain.Book;

import java.util.List;

public interface BookDao {


 Book add(String title,String code, long authorId, long genreId) throws Exception;
 Book add(String bookTitle, String bookCode, String authorName, String genreTitle) throws Exception;
 long getCount();
 List<Book> getAll(int page, int amountByOnePage);
 List<Book> findByTitle(String title) throws Exception;
 Book findById(long id) throws Exception;
 Book update(long id, String title,String code) throws Exception;
 Book update(long id, String bookTitle, String bookCode, long authorId, long genreId) throws Exception;
 void delete(long id) throws Exception;
 void deleteAll();
}
