package com.example.demo.domain;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//import static  com.example.demo.domain.Book.COLLECTION_TITLE;
//import static  com.example.demo.domain.Book.FIELD_TITLE;
//import static  com.example.demo.domain.Book.FIELD_CODE;
@Entity @Table(name = Book.COLLECTION_TITLE,
        uniqueConstraints= @UniqueConstraint(columnNames={Book.FIELD_TITLE, Book.FIELD_CODE}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Book {
    public static final String COLLECTION_TITLE = "Books";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_CODE = "code";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = FIELD_TITLE)
    @NonNull
    private String title;

    @Column(name = FIELD_CODE)
    @NonNull
    private String code;
}
