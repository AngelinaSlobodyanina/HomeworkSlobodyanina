package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "experience")
public class Experience {


    @Id
    @GeneratedValue
    @Column(name = "experience_id")
    private Integer id;
    @Column(name = "experience")
    private int experience;
    @Column(name = "place")
    private String place;
    @ManyToOne
    private Author author;

    public Experience(int experience, String place, Author author) {
        this.experience = experience;
        this.place = place;
        this.author = author;
    }

    public Experience() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Experience id: " + id + ", experience: " + experience + ", place: " + place;
    }
}


