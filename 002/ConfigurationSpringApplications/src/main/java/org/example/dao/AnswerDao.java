package org.example.dao;


import java.io.IOException;
import java.util.List;

public interface AnswerDao {
    //read question file
    void ReadFileDataCSV(String fileName, String delimiter) throws IOException;

    //read answer file
    List<String> ReadFileAnswerCSV(String fileName, String delimiter) throws IOException;

    //read person answer from the screen
    List<String> PersonAnswers() throws IOException;

    //read person name from the screen
    String Person();
}
