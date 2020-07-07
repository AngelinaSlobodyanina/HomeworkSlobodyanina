package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.*;

@Service
public class AuthorDaoImpl implements AuthorDao{
    @Autowired
private AuthorRepository authorRepository;

        @Override
        public Author add(String name) throws Exception {
            Author author = new Author(name);
            try {
                authorRepository.save(author);
            }
            catch(DataIntegrityViolationException exception) {
                handlerException(exception, author.toString());
            }
            return author;
        }

        @Override
        public long getCount() {
            return authorRepository.count();
        }

        @Override
        public List<Author> getAll(int page, int amountByOnePage) {
            return authorRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
        }

        @Override
        public Author findById(long id) {
            return authorRepository.findById(id).orElseThrow(()->
                    new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Author.class.getSimpleName(), id)));
        }

        @Override
        public List<Author> find(String name) throws Exception {
            List<Author> authors = new ArrayList<>();
            try {
                authorRepository.findByName(name).forEach(authors::add);
            }
            catch (DataIntegrityViolationException exception) {
                handlerException(exception, Author.class.getSimpleName());
            }
            return authors;
        }

        @Override
        public List<Book> getBooks(long id){
            List<Book> books = new ArrayList<>();
            authorRepository.getBooksByID(id).forEach(books::add);
            return books;
        }

        @Override
        public Author update(long id, String name) throws Exception {
            Author author = authorRepository.findById(id).orElseThrow(()->
                    new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Author.class.getSimpleName(), id)));
            if(name!= null)
                author.setName(name);

            try {
                authorRepository.save(author);
            }
            catch (DataIntegrityViolationException exception) {
                handlerException(exception, Author.class.getSimpleName());
            }
            return author;
        }

        @Override
        public void delete(long id, boolean withBook) throws Exception {
            if(getBooks(id).isEmpty() && !withBook)
                throw new IllegalStateException(String.format(ASSOCIATED_ERROR_STRING, Author.class.getSimpleName(), Book.class.getSimpleName()));
            else
                deleteWithBook(id);
        }

        @Override
        public void delete(long id) throws Exception {
            if(!getBooks(id).isEmpty())
                throw new IllegalStateException(String.format(ASSOCIATED_ERROR_STRING, Author.class.getSimpleName(), Book.class.getSimpleName()));
            else
                deleteWithBook(id);
        }

        private void deleteWithBook(long id) throws Exception {
            try {
                authorRepository.deleteById(id);
            }
            catch (DataIntegrityViolationException exception) {
                handlerException(exception, Author.class.getSimpleName());
            }
        }

        @Override
        public void deleteAll() {
            authorRepository.deleteAll();
        }
}