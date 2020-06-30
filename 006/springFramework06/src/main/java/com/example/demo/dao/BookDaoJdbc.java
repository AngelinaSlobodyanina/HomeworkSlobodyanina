package com.example.demo.dao;

import com.example.demo.domain.Book;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao{
    private  JdbcOperations jdbc;
    private  NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations)
    {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into books (id, `title`, `code`) values (?, ?, ?)", book.getId(), book.getTitle(), book.getCode());
    }

    @Override
    public Book getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select * from books where id = :id", params, new BookDaoJdbc.BooksMapper()
        );
    }

    @Override
    public List<Book> findAll() {
        return jdbc.query("select * from books", new BookDaoJdbc.BooksMapper());
    }

    @Override
    public void deleteById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

    private static class BooksMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String code = resultSet.getString("code");
            return new Book(id, title, code);
        }
    }
}
