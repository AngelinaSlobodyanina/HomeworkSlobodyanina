package org.example.dao;

import org.example.domain.Answers;
import org.example.domain.Questions;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnswerDaoSimple implements AnswerDao {

    public void ReadFileDataCSV(String fileDataCsv, String delimiter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileDataCsv));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Questions> questionsList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Questions questions = new Questions();
            scanner = new Scanner(line);
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    questions.setQuestion(data);
                else if (index == 1)
                    questions.setAnswer1(data);
                else if (index == 2)
                    questions.setAnswer2(data);
                else if (index == 3)
                    questions.setAnswer3(data);
                else if (index == 4)
                    questions.setAnswer4(data);
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            questionsList.add(questions);
        }


        reader.close();
        System.out.println(questionsList);
    }


    public List<String> ReadFileAnswerCSV(String fileAnswerCsv, String delimiter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileAnswerCsv));
        String line = null;
        Scanner scanner = null;
        List<String> answersList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Answers answers = new Answers();
            scanner = new Scanner(line);
            scanner.useDelimiter(delimiter);
            while (scanner.hasNext()) {
                String data = scanner.next();
                answers.setCorrectAnswer(data);
            }
            answersList.add(answers.toString());
        }


        reader.close();

        return answersList;
    }

    public String Person() {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        return name;

    }

    public List<String> PersonAnswers() throws IOException {

        BufferedReader reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            result.add(s);
        }
        return result;

    }

}
