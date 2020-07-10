package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static com.example.demo.domain.Experience.COLLECTION_TITLE;
import static com.example.demo.domain.Experience.FIELD_PLACE;
import static com.example.demo.domain.Experience.FIELD_YEARS;

@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_YEARS, FIELD_PLACE}))
@Data @NoArgsConstructor @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"id", "authors"})
@ToString(exclude = {"authors"})
public class Experience {
    public static final String COLLECTION_TITLE = "experiences";
    public static final String FIELD_YEARS = "years";
    public static final String FIELD_PLACE = "place";
    public static final String FIELD_AUTHOR_ID = "author_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(name = FIELD_YEARS)
    private int years;
    @Column(name = FIELD_PLACE)
    private String place;
    @OneToMany(
            mappedBy = COLLECTION_TITLE,
            fetch = FetchType.LAZY
    )
    private List<Author> author;

}