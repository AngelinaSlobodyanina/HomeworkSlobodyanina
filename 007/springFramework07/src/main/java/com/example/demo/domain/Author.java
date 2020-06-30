package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany
            /*(cascade = CascadeType.ALL,
            mappedBy = "author",
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )*/
    private List<Book> bookList;
    @OneToOne/*(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")*/
    private Genre genre;

    public Author() {
    }

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(Integer id, String name, List<Book> book, Genre genre) {
        this.id = id;
        this.name = name;
        this.bookList = book;
        this.genre = genre;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public Genre getGenre() {
        return genre;
    }

    public Author(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author id: " + id + ", name: " + name +
                ",\n Book: " + bookList+
                ",\n Genre: "+genre;
    }
}


//import javax.persistence.*;

//@Entity // This tells Hibernate to make a table out of this class
//@Table(name="authors")
/*public  class Author{
  @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="author_id")
    private Integer id;
    @Column(name="author_name")
    private String name;
    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}*/
/*public class Author {
    private final Integer id;
    private final String name;

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}*/
