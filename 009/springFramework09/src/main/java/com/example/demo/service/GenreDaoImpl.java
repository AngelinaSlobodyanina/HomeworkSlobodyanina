package com.example.demo.service;

import com.example.demo.dao.GenreDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.example.demo.service.HandlerException.*;

@Service
public class GenreDaoImpl implements GenreDao {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre add(String title) throws Exception {
        Genre genre = new Genre(title);
        try{
            genreRepository.save(genre);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, genre.toString());
        }
        return genre;
    }

    @Override
    public long getCount() {
        return genreRepository.count();
    }

    @Override
    public List<Genre> getAll(int page, int amountByOnePage) {
        return genreRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Genre findById(long id) throws Exception {
        Genre byId = genreRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Genre.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Genre> find(String title) throws Exception {
        List<Genre> genres = new ArrayList<>();
        try {
            genreRepository.findByTitle(title).forEach(genres::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Genre.class.getSimpleName());
        }
        return genres;
    }

    @Override
    public List<Book> getBooks(long id) {
        List<Book> books = new ArrayList<>();
        genreRepository.getBooksByID(id).forEach(books::add);
        return books;
    }

    @Override
    public Genre update(long id, String title) throws Exception {
        Genre genre = genreRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Genre.class.getSimpleName(), id)));
        if(title!= null) {
            genre.setTitle(title);
            try {
                genreRepository.save(genre);
            }
            catch (DataIntegrityViolationException exception) {
                handlerException(exception, Author.class.getSimpleName());
            }
        }
        return genre;
    }

    @Override
    public void delete(long id, boolean withBook) throws Exception {
        if(getBooks(id).isEmpty() && !withBook)
            throw new IllegalStateException(String.format(ASSOCIATED_ERROR_STRING, Genre.class.getSimpleName(), Book.class.getSimpleName()));
        else
            deleteWithBook(id);
    }

    @Override
    public void delete(long id) throws Exception {
        if(getBooks(id).isEmpty())
            throw new IllegalStateException(String.format(ASSOCIATED_ERROR_STRING, Genre.class.getSimpleName(), Book.class.getSimpleName()));
        else
            deleteWithBook(id);
    }

    private void deleteWithBook(long id) throws Exception {
        try {
            genreRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Genre.class.getSimpleName());
        }
    }

    @Override
    public void deleteAll() {
        genreRepository.deleteAll();
    }
}