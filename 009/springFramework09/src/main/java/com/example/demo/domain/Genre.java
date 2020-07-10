package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static com.example.demo.domain.Genre.COLLECTION_TITLE;
import static com.example.demo.domain.Genre.FIELD_TITLE;


@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_TITLE}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id", "books"})
@ToString(exclude = "books")
public class Genre {
    public static final String COLLECTION_TITLE = "genres";
    public static final String FIELD_TITLE = "title";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = FIELD_TITLE)
    private String title;
    @OneToMany(mappedBy = COLLECTION_TITLE, fetch = FetchType.LAZY)
    private List<Book> book;

}