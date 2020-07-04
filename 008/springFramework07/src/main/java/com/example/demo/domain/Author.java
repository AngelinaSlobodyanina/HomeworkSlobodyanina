package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_of_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> bookList;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Experience> experience = new ArrayList<Experience>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Author() {
    }

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name, Set<Book> book, Genre genre) {
        this.name = name;
        this.bookList = book;
        this.genre = genre;
    }

    public void addExperience(Experience experience) {
        this.experience.add(experience);
    }

    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
                ",\n Book: " + bookList +
                ",\n Genre: " + genre +
                ",\n Experience: " + experience;
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
