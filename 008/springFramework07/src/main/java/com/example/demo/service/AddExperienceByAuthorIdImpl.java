package com.example.demo.service;

import com.example.demo.dao.AddExperienceByAuthorId;
import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.ExperienceDao;
import com.example.demo.domain.Author;
import com.example.demo.domain.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddExperienceByAuthorIdImpl implements AddExperienceByAuthorId {

    private ExperienceDao experienceDao;
    private AuthorDao authorDao;

    @Autowired
    public AddExperienceByAuthorIdImpl(ExperienceDao experienceDao, AuthorDao authorDao) {
        this.experienceDao = experienceDao;
        this.authorDao = authorDao;
    }

    @Override
    @Transactional
    public void addExperienceByAuthorId(int id, int number, String place) {
        Author author = authorDao.getById(id);
        if (author != null) {
            Experience experience = new Experience(number, place, author);
            experienceDao.insert(experience);
            author.addExperience(experience);
            authorDao.insert(author);
        } else {
            System.out.println("Error");
        }
    }
}
