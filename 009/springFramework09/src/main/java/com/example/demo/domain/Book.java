package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Book.COLLECTION_TITLE;
import static com.example.demo.domain.Book.FIELD_TITLE;
import static com.example.demo.domain.Book.FIELD_CODE;

@Data
@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_TITLE, FIELD_CODE}))
@EqualsAndHashCode(exclude = {"id"})
public class Book {
    public static final String COLLECTION_TITLE = "books";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_CODE = "code";
    public static final String FIELD_AUTHOR_ID = "author_id";
    public static final String FIELD_GENRE_ID = "genre_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = FIELD_TITLE)
    @NonNull
    private String title;
    @Column(name = FIELD_CODE)
    @NonNull
    private String code;
    @ManyToOne
    @JoinColumn(name = FIELD_AUTHOR_ID)
    @NonNull
    private Author authors;
    @ManyToOne
    @JoinColumn(name = FIELD_GENRE_ID)
    @NonNull
    private Genre genre;

    public Book() {
    }

    public Book(@NonNull String title, @NonNull String code, @NonNull Author authors, @NonNull Genre genre) {

        this.title = title;
        this.code = code;
        this.authors = authors;
        this.genre = genre;
    }

    public Book(@NonNull Author authors, @NonNull Genre genre) {
        this.authors = authors;
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}