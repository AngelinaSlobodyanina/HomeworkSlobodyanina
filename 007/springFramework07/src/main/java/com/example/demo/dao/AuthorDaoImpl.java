package com.example.demo.dao;

import com.example.demo.domain.Author;
import org.springframework.stereotype.Repository;

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
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Author author){
        em.persist(author);
    }
    @Override
    public Author getById(Integer id){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authorRoot = cq.from(Author.class);
        Predicate idPredicate = cb.equal(authorRoot.get("id"), id);
        cq.where(idPredicate);
        TypedQuery<Author> query = em.createQuery(cq);
        return query.getResultList().get(0);
        //return em.find(Author.class,id);
    }
    @Override
    public Author getByName(String name){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authorRoot = cq.from(Author.class);
        Predicate idPredicate = cb.equal(authorRoot.get("name"), name);
        cq.where(idPredicate);
        TypedQuery<Author> query = em.createQuery(cq);
        return query.getResultList().get(0);
       /*TypedQuery<Author> query = em.createQuery(
                "select a from author a where a.name = :name",
                Author.class);
        query.setParameter("name", name);
        return query.getSingleResult();*/
    }
    @Override
    public List<Author> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authorRoot = cq.from(Author.class);
        TypedQuery<Author> query = em.createQuery(cq);
        return query.getResultList();
       /* TypedQuery<Author> query = em.createQuery(
                "select a from author a",
                Author.class);
        return query.getResultList();*/
    }

}