package com.example.demo.dao;

import com.example.demo.domain.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDaoCSVCsvImplTest {
    @Test
    void testGetQuestionsFromFile() {
    }

    @Test
    void getQuestionsFromFile() throws IOException {
        /*
        QuestionDaoCsvImpl obtained = new QuestionDaoCsvImpl();
        List<Question> expected =new ArrayList<>();
        List<String> answers1=new ArrayList<>(Arrays.asList(new String[] {"2x-8", "8-2x", "(x-4)/2", "(4-x)/2)"}));
        expected.add(new Question( 1,"2y+4=x, y=?", answers1,3);
        List<String> answers2=new ArrayList<>(Arrays.asList("(0,-2)", "(-2,0)", "(1,0)", "(0,1)"));
        expected.add(new Question( 2,"Найти точку пересечения функции y=2x-2 с осью Ox.",
                answers2,3);

        Assertions.assertEquals(
                obtained.getQuestionsFromFile("src/main/resources/data.csv",";"), expected);
        */

    }
}