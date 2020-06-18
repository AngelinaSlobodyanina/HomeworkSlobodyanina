package com.example.demo005.service;

import com.example.demo005.domain.Person;
import com.example.demo005.domain.Question;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceImplTest {

    @Test
    void checkAnswers(int first, int second,int third,int forth, int fifth, int expectedResult,List<Integer> rightAnswers) {
        TestServiceImpl testService =new TestServiceImpl();
        List<Integer> givenAnswers = new ArrayList<>();
        givenAnswers.add(first);
        givenAnswers.add(second);
        givenAnswers.add(third);
        givenAnswers.add(forth);
        givenAnswers.add(fifth);
        assertEquals(expectedResult,testService.checkAnswers(givenAnswers,rightAnswers),
                ()-> first +", "+second+", "+third+", "+forth+", "+fifth+" is"+expectedResult+" correct answer(s)");
    }

    @Test
    void doTest(int expectedResult, Person person, List<Question> question) {
        TestServiceImpl testService =new TestServiceImpl();
        assertEquals(expectedResult,testService.doTest(person, question));
    }
}