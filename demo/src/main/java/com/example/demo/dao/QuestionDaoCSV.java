package com.example.demo.dao;

import com.example.demo.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDaoCSV {

    List<Question> getQuestionsFromFile(String csvFileName) throws IOException;

    List<Question> getQuestionsFromFile(String csvFileName, String delimiter) throws IOException;
}