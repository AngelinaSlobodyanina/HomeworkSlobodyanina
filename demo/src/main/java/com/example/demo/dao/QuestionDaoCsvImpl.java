package com.example.demo.dao;

import com.example.demo.domain.Question;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Repository("questionDao")
public class QuestionDaoCsvImpl implements QuestionDao {

    private static final String CSV_DEFAULT_DELIMITER = ";";


    public List<Question> getQuestionsFromFile(String csvFileName) throws IOException {

        return getQuestionsFromFile(csvFileName, CSV_DEFAULT_DELIMITER);
    }


    public List<Question> getQuestionsFromFile(String csvFileName, String delimiter) throws IOException {


        List<Question> questions = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(csvFileName));

        String line;
        while ((line = reader.readLine()) != null) {

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(delimiter);
            if (scanner.hasNext()) {

                int questionNumber = scanner.nextInt();

                if (scanner.hasNext()) {

                    String questionText = scanner.next();

                    if (scanner.hasNext()) {

                        int correctAnswerIndex = scanner.nextInt();
                        List<String> answers = new ArrayList<>();

                        while (scanner.hasNext()) {
                            String answerText = scanner.next();
                            answers.add(answerText);
                        }

                        questions.add(new Question(questionNumber, questionText, answers, correctAnswerIndex));
                    }
                }
            }

        }

        reader.close();
        return questions;
    }
}