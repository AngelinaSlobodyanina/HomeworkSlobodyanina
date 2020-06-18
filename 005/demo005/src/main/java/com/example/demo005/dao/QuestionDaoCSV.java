package com.example.demo005.dao;

import com.example.demo005.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDaoCSV {

    List<Question> getQuestionsFromFile(String csvFileName) throws IOException;

    List<Question> getQuestionsFromFile(String csvFileName, String delimiter) throws IOException;
}