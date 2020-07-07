package com.example.demo.repository;

import com.example.demo.domain.Author;
import com.example.demo.domain.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExperienceRepository extends PagingAndSortingRepository<Experience, Long> {
    @Query("select a from Author a left join a.experience e where e.id = ?1")
    Iterable<Author> getAuthorByID(long id);

    Iterable<Experience> findByPlace(String place);
}