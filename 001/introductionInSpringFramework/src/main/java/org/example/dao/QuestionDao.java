package org.example.dao;

import org.example.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {

    List<Question> getQuestionsFromFile(String csvFileName) throws IOException;

    List<Question> getQuestionsFromFile(String csvFileName, String delimiter) throws IOException;
}
