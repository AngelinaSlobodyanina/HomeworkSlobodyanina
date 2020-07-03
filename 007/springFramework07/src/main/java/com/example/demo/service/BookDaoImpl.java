package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Book book){
        em.persist(book);
    }
    @Override
    public Book getById(Integer id){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> authorRoot = cq.from(Book.class);
        Predicate idPredicate = cb.equal(authorRoot.get("id"), id);
        cq.where(idPredicate);
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList().get(0);
        //return em.find(Book.class,id);
    }
    @Override
    public Book getByTitle(String title){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> authorRoot = cq.from(Book.class);
        Predicate idPredicate = cb.equal(authorRoot.get("title"), title);
        cq.where(idPredicate);
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList().get(0);
       /*TypedQuery<Book> query = em.createQuery(
                "select b from book b where b.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getSingleResult();*/
    }
    @Override
    public Book getByCode(String code){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> authorRoot = cq.from(Book.class);
        Predicate idPredicate = cb.equal(authorRoot.get("code"), code);
        cq.where(idPredicate);
        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList().get(0);
        /*TypedQuery<Book> query = em.createQuery(
                "select b from book b where b.code = :code",
                Book.class);
        query.setParameter("code", code);
        return query.getSingleResult();*/
    }
    @Override
    public List<Book> findAll(){
        TypedQuery<Book> query = em.createQuery(
                "select b from book b",
                Book.class);
        return query.getResultList();
    }
}
