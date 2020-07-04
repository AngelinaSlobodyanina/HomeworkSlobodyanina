package com.example.demo.service;

import com.example.demo.dao.ExperienceDao;
import com.example.demo.domain.Experience;
import com.example.demo.domain.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ExperienceDaoImpl implements ExperienceDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Experience experience) {
        em.persist(experience);
    }
}
