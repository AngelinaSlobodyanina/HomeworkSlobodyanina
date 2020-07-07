package com.example.demo.service;

import com.example.demo.dao.ExperienceDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Experience;
import com.example.demo.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.*;

@Service
public class ExperienceDaoImpl implements ExperienceDao {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Experience add(int years,String place) throws Exception {
        Experience experience = new Experience(years, place);
        try{
            experienceRepository.save(experience);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, exception.toString());
        }
        return experience;
    }

    @Override
    public long getCount() {
        return experienceRepository.count();
    }

    @Override
    public List<Experience> getAll(int page, int amountByOnePage) {
        return experienceRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Experience findById(long id) throws Exception {
        Experience byId = experienceRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Experience.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Experience> find(String place) throws Exception {
        List<Experience> experiences = new ArrayList<>();
        try {
            experienceRepository.findByPlace(place).forEach(experiences::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Experience.class.getSimpleName());
        }
        return experiences;
    }
@Override
    public List<Author> getAuthors(long id){
    List<Author> author = new ArrayList<>();
    experienceRepository.getAuthorByID(id).forEach(author::add);
    return author;
}
    @Override
    public Experience update(long id, String place ) throws Exception {
        Experience experience = experienceRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Experience.class.getSimpleName(), id)));
        if(place!= null) {
            experience.setPlace(place);
            try {
                experienceRepository.save(experience);
            }
            catch (DataIntegrityViolationException exception) {
                handlerException(exception, Author.class.getSimpleName());
            }
        }
        return experience;
    }



    private void deleteWithAuthor(long id) throws Exception {
        try {
            experienceRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Experience.class.getSimpleName());
        }
    }

    @Override
    public void deleteAll() {
        experienceRepository.deleteAll();
    }
}
