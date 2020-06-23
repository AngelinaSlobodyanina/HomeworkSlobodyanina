package com.example.demo;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.dao.BookDaoJdbc;
import com.example.demo.dao.GenreDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {

        //SpringApplication.run(DemoApplication.class, args);


   /* @Bean
    public CommandLineRunner runATest(ApplicationContext ctx) {
        return args -> {
            BookDao bookDao = ctx.getBean(BookDao.class);

            System.out.println("All count " + bookDao.count());

            bookDao.insert(new Book(null, "Stainless Steel Rat", "978-5-389-10331-3"));

            System.out.println("All count " + bookDao.count());

            Book book = bookDao.getById(2);

            System.out.println("Book id: " + book.getId() + ", title: " + book.getTitle() + ", code: " + book.getCode());

            Book book1 = bookDao.getById(8);

            System.out.println("Book id: " + book1.getId() + ", title: " + book1.getTitle() + ", code: " + book1.getCode());


        };

    }*/


        ApplicationContext context = SpringApplication.run(DemoApplication.class);

        AuthorDao authorDao = context.getBean(AuthorDao.class);

        System.out.println("All count " + authorDao.count());

        authorDao.insert(new Author(null, "Harry Harrison"));

        System.out.println("All count " + authorDao.count());

        Author author = authorDao.getById(2);

        System.out.println("Author id: " + author.getId() + ", name: " + author.getName());

        Author author1 = authorDao.getById(5);

        System.out.println("Author id: " + author1.getId() + ", name: " + author1.getName());


        BookDao bookDao = context.getBean(BookDao.class);

        System.out.println("All count " + bookDao.count());

        bookDao.insert(new Book(null, "Stainless Steel Rat", "978-5-389-10331-3"));

        System.out.println("All count " + bookDao.count());

        Book book = bookDao.getById(2);

        System.out.println("Book id: " + book.getId() + ", title: " + book.getTitle() + ", code: " + book.getCode());

        Book book1 = bookDao.getById(8);

        System.out.println("Book id: " + book1.getId() + ", title: " + book1.getTitle() + ", code: " + book1.getCode());


        GenreDao genreDao = context.getBean(GenreDao.class);

        System.out.println("All count " + genreDao.count());

        genreDao.insert(new Genre(null, "science fiction"));

        System.out.println("All count " + genreDao.count());

        Genre genre = genreDao.getById(2);

        System.out.println("Genre id: " + genre.getId() + ", title: " + genre.getTitle());

        Genre genre1 = genreDao.getById(5);

        System.out.println("Genre id: " + genre1.getId() + ", title: " + genre1.getTitle());


        Console.main(args);
    }

}
