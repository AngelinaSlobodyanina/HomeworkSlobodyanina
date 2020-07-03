package com.example.demo.service;

import com.example.demo.dao.GenreDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Genre;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class GenreDaoImpl implements GenreDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Genre genre){
        em.persist(genre);
    }
    @Override
    public Genre getById(Integer id){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> authorRoot = cq.from(Genre.class);
        Predicate idPredicate = cb.equal(authorRoot.get("id"), id);
        cq.where(idPredicate);
        TypedQuery<Genre> query = em.createQuery(cq);
        return query.getResultList().get(0);
        //return em.find(Genre.class,id);
    }
    @Override
    public Genre getByTitle(String title){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Genre> cq = cb.createQuery(Genre.class);
        Root<Genre> authorRoot = cq.from(Genre.class);
        Predicate idPredicate = cb.equal(authorRoot.get("title"), title);
        cq.where(idPredicate);
        TypedQuery<Genre> query = em.createQuery(cq);
        return query.getResultList().get(0);
       /*TypedQuery<Genre> query = em.createQuery(
                "select g from genre g where g.title = :title",
                Genre.class);
        query.setParameter("title", title);
        return query.getSingleResult();*/
    }

    @Override
    public List<Genre> findAll(){
        TypedQuery<Genre> query = em.createQuery(
                "select g from genre g",
                Genre.class);
        return query.getResultList();
    }
}
