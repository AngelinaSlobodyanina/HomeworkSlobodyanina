package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.dao.GenreDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private GenreDao genreDao;


    @Override
    public Book add(String title, String code, long authorId, long genreId) throws Exception {
        Book book = new Book(title, code, authorDao.findById(authorId), genreDao.findById(genreId));
        book = add(book);
        return book;
    }

    @Override
    public Book add(String bookTitle, String bookCode, String authorName, String genreTitle) throws Exception {
        Author addedAuthor = authorDao.add(authorName);
        Genre addedGenre = genreDao.add((genreTitle));
        Book book = new Book(bookTitle, bookCode, addedAuthor, addedGenre);
        book = add(book);
        return book;
    }

    private Book add(Book book) throws Exception {
        try{
            bookRepository.save(book);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, book.toString());
        }
        return book;
    }

    @Override
    public long getCount() {
        return bookRepository.count();
    }

    @Override
    public List<Book> getAll(int page, int amountByOnePage) {
        return bookRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();

    }

    @Override
    public List<Book> findByTitle(String subTitle) throws Exception {
        List<Book> books = new ArrayList<>();
        try {
            bookRepository.findByTitleContaining(subTitle).forEach(books::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
        return books;
    }

    @Override
    public Book findById(long id) throws Exception {
        Book byId = bookRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Book.class.getSimpleName(), id)));
        return byId;
    }


    @Override
    public Book update(long id, String title,String code) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Book.class.getSimpleName(), id)));
        if(title!= null)
            book.setTitle(title);
        if(code!= null)
            book.setCode(code);
        try {
            bookRepository.save(book);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
        return book;
    }

    @Override
    public Book update(long id, String bookTitle, String bookCode, long authorId, long genreId) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Book.class.getSimpleName(), id)));
        if(bookTitle!= null)
            book.setTitle(bookTitle);
        if(bookCode!= null)
            book.setCode(bookCode);
        if(authorId != 0)
            book.setAuthors(authorDao.findById(authorId));
        if(genreId != 0)
            book.setGenre(genreDao.findById(genreId));
        try{
            bookRepository.save(book);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
        return book;
    }

    @Override
    public void delete(long id) throws Exception {
        try {
            bookRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}