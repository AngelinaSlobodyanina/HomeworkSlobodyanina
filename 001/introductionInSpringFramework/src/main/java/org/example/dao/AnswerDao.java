package org.example.dao;

import org.example.domain.Answers;
import org.example.domain.Questions;

import java.io.IOException;
import java.util.List;

public interface AnswerDao {
    void ReadFileDataCSV(String fileName, String delimiter)throws IOException;
    List<String> ReadFileAnswerCSV(String fileName, String delimiter)throws IOException;
    List<String> PersonAnswers();
}
