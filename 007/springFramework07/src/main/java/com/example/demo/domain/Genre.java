package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "genre")
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private  Integer id;
    @Column(name = "title")
    private  String title;

    public Genre(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
    public Genre(Integer id){
        this.id=id;
    }
    public Genre(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Genre id: " + id + ", title: "+title;
    }
}

/*public class Genre {
    private final Integer id;
    private final String title;

    public Genre(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}*/
