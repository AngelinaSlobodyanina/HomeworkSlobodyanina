package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static com.example.demo.domain.Experience.COLLECTION_TITLE;
import static com.example.demo.domain.Experience.FIELD_PLACE;
import static com.example.demo.domain.Experience.FIELD_YEARS;

@Data
@Entity
@Table(name = COLLECTION_TITLE, uniqueConstraints = @UniqueConstraint(columnNames = {FIELD_YEARS, FIELD_PLACE}))
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
    @NonNull
    private int years;
    @Column(name = FIELD_PLACE)
    @NonNull
    private String place;
    @OneToMany(
            mappedBy = COLLECTION_TITLE,
            fetch = FetchType.LAZY
    )
    private List<Author> author;

    public Experience() {
    }

    public Experience(@NonNull int years, @NonNull String place) {
        this.years = years;
        this.place = place;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}