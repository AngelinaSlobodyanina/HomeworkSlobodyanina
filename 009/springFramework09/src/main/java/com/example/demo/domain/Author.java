package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.demo.domain.Author.COLLECTION_TITLE;
import static com.example.demo.domain.Author.FIELD_NAME;

@Data
@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_NAME}))
@EqualsAndHashCode(exclude = {"id", "books"})
@ToString(exclude = {"books"})

public class Author {
    public static final String COLLECTION_TITLE = "authors";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_EXPERIENCE_ID = "experience_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = FIELD_NAME)
    @NonNull
    private String name;
    @OneToMany(
            mappedBy = COLLECTION_TITLE,
            fetch = FetchType.LAZY
    )
    private List<Book> book;


    @ManyToOne
    @JoinColumn(name = FIELD_EXPERIENCE_ID)
    @NonNull
    private Experience experience;

    public Author() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(@NonNull String name) {
        this.name = name;
    }
}