package com.example.demo.controller;

import com.example.demo.dao.AddExperienceByAuthorId;
import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.dao.GenreDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

@ShellComponent
public class ShellController {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    public AddExperienceByAuthorId addExperienceByAuthorId;


    @ShellMethod(key = "insertSomeAuthors", value = "insert some authors")
    public void insertSomeAuthors() {
        authorDao.insert(new Author(null, "Harry_Harrison"));
        authorDao.insert(new Author(null, "Arthur_Conan Doyle"));
        authorDao.insert(new Author(null, "Agatha_Christie"));
        authorDao.insert(new Author(null, "Luc_Besson"));
        authorDao.insert(new Author(null, "Christie_Golden"));
    }

    @ShellMethod(key = "insertSomeBooks", value = "insert some books")
    public void insertSomeBooks() {
        bookDao.insert(new Book(null, "Sherlock_Holmes", "978-5-907120-60-0"));
        bookDao.insert(new Book(null, "Professor_Challenger", "978-5-8475-1121-6"));

        bookDao.insert(new Book(null, "Murder_on_the_Orient_Express", "978-5-04-098115-1"));
        bookDao.insert(new Book(null, "Ten_Little_Niggers", "978-5-9925-0837-6"));
        bookDao.insert(new Book(null, "Poirot_Investigates", "978-5-04-107820-1"));

        bookDao.insert(new Book(null, "Arthur_and_minimoys", "978-90225-43-009"));

        bookDao.insert(new Book(null, "World_of_Warcraft", "978-5-17-112285-0"));
    }

    @ShellMethod(key = "insertSomeGenres", value = "insert some genres")
    public void insertSomeGenres() {
        genreDao.insert(new Genre(null, "detective"));
        genreDao.insert(new Genre(null, "science_fiction_novel"));
        genreDao.insert(new Genre(null, "adventures"));
        genreDao.insert(new Genre(null, "fantasy"));
    }

    /*@ShellMethod(key = "insertAuthorWihtSomeBooks", value = "insert authors wiht some books")
    public void insertAuthorWihtSomeBooks() {
        authorDao.insert(new Author(null, "Harry_Harrison", new Book(null,"Stainless_Steel_Rat", "978-5-389-10331-3")));
        authorDao.insert(new Author(null, "Harry_Harrison", new Book(null,"Ethical engineer","978-5-389-11345-6")));
        authorDao.insert(new Author(null, "Arthur_Conan Doyle", new Book(null, "Sherlock_Holmes", "978-5-907120-60-0")));
        authorDao.insert(new Author(null, "Arthur_Conan Doyle", new Book(null, "Professor_Challenger", "978-5-8475-1121-6")));
        authorDao.insert(new Author(null, "Agatha_Christie",new Book(null, "Murder_on_the_Orient_Express", "978-5-04-098115-1")));
        authorDao.insert(new Author(null, "Agatha_Christie",new Book(null, "Ten_Little_Niggers", "978-5-9925-0837-6")));
        authorDao.insert(new Author(null, "Agatha_Christie",new Book(null, "Poirot_Investigates", "978-5-04-107820-1")));
    }*/
    @ShellMethod(key = "findAuthorById", value = "find author by id")
    public void findAuthorById(Integer id) {
        Author author = authorDao.getById(id);
        System.out.println("Author id: " + author.getId() + ", name: " + author.getName());
    }

    @ShellMethod(key = "findAuthorByName", value = "find author by name")
    public void findAuthorByName(String name) {
        Author author = authorDao.getByName(name);
        System.out.println("Author id: " + author.getId() + ", name: " + author.getName());
    }

    @ShellMethod(key = "findBookById", value = "find book by id")
    public void findBookById(Integer id) {
        Book book = bookDao.getById(id);
        System.out.println("Book id: " + book.getId() + ", title: " + book.getTitle() + ", code: " + book.getCode());
    }

    @ShellMethod(key = "findBookByTitle", value = "find book by title")
    public void findBookByTitle(String title) {
        Book book = bookDao.getByTitle(title);
        System.out.println("Book id: " + book.getId() + ", title: " + book.getTitle() + ", code: " + book.getCode());
    }

    @ShellMethod(key = "findBookByCode", value = "find book by code")
    public void findBookByCode(String code) {
        Book book = bookDao.getByCode(code);
        System.out.println("Book id: " + book.getId() + ", title: " + book.getTitle() + ", code: " + book.getCode());
    }

    @ShellMethod(key = "findGenreById", value = "find genre by id")
    public void findGenreById(Integer id) {
        Genre genre = genreDao.getById(id);
        System.out.println("Genre id: " + genre.getId() + ", title: " + genre.getTitle());
    }

    @ShellMethod(key = "findGenreByTitle", value = "find genre by title")
    public void findGenreByTitle(String title) {
        Genre genre = genreDao.getByTitle(title);
        System.out.println("Genre id: " + genre.getId() + ", title: " + genre.getTitle());
    }

    @ShellMethod(key = "findAllAuthors", value = "find all authors")
    public void findAllAuthors() {
        Iterator<Author> authorIterator = authorDao.findAll().listIterator();
        System.out.println();
        for (; authorIterator.hasNext(); ) {
            System.out.println(authorIterator.next());
        }
        System.out.println();
    }

    @ShellMethod(key = "insert", value = "Insert author (author_name, book_title, book_code, genre)")
    public void addAuthor(String author, String book_title, String book_code, String genre) {
        String[] bookTitleStrArr = book_title.split(",");
        String[] bookCodeStrArr = book_code.split(",");
        HashSet<Book> bookList = new HashSet<>();
        for (int i = 0; i < bookTitleStrArr.length; i++)
            bookList.add(new Book(bookTitleStrArr[i], bookCodeStrArr[i]));


        authorDao.insert(new Author(author, bookList, new Genre(genre)));
    }

    @ShellMethod(key = "addExperienceByAuthorId", value = "add experience by author id")
    public void addExperienceByAuthorId(int id, int experience, String place) {
        addExperienceByAuthorId.addExperienceByAuthorId(id, experience, place);

    }
}
