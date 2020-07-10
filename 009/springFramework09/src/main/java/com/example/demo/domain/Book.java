package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static com.example.demo.domain.Book.COLLECTION_TITLE;
import static com.example.demo.domain.Book.FIELD_TITLE;
import static com.example.demo.domain.Book.FIELD_CODE;


@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_TITLE, FIELD_CODE}))
@Data @NoArgsConstructor @RequiredArgsConstructor
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
    private String title;
    @Column(name = FIELD_CODE)
    private String code;
    @ManyToOne
    @JoinColumn(name = FIELD_AUTHOR_ID)
    private Author authors;
    @ManyToOne
    @JoinColumn(name = FIELD_GENRE_ID)
    private Genre genre;

}