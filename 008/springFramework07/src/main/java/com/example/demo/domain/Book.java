package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private  Integer id;
    @Column(name = "title")
    private  String title;
    @Column(name = "code")
    private  String code;
   /* @ManyToMany
    private List<Genre> genres;
    @ManyToOne
    private Author author;*/
   @ManyToMany(fetch = FetchType.EAGER)
   private List<Author> authors = new ArrayList<Author>();

    public Book(Integer id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code =code;
    }
    public Book( String title,String code) {
        this.title = title;
        this.code=code;
    }
    public Book(){
    }
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Book id: " + id + ", title: "+title+",code: "+code;
    }
}

/*public class Book {
    private final Integer id;
    private final String title;
    private final String code;

    public Book(Integer id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code =code;
    }

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCode() {
        return code;
    }
}*/
