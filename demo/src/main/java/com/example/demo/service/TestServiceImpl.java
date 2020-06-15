package com.example.demo.service;

import com.example.demo.dao.QuestionDaoCSV;
import com.example.demo.domain.Person;
import com.example.demo.domain.Question;

import java.io.IOException;
import java.util.*;

import static java.lang.System.lineSeparator;


public class TestServiceImpl implements TestService {
    private MessageLocale locale;

    //MessageSource resources = new ClassPathXmlApplicationContext("spring-context.xml");


    String READ_QUESTIONS_ERROR_MESSAGE = locale.message("readQuestionError");
    String ENTER_FIRST_NAME_MESSAGE = locale.message("enterFirstName");
    String ENTER_LAST_NAME_MESSAGE = locale.message("enterLastName");

    String RESULT_MESSAGE1 = locale.message("result1");
    String RESULT_MESSAGE2 = locale.message("result2");

    String QUESTION_NUMBER_MESSAGE = locale.message("questionNumber");
    String QUESTION_CHOICE_MESSAGE = locale.message("questionChoice");
    String QUESTION_ENTER_MESSAGE = locale.message("questionEnter");

    String ANSWER_INPUT_ERROR = locale.message("answerInputError");
    String EMPTY_QUESTIONS_ERROR = locale.message("emptyQuestionsError");


    private QuestionDaoCSV questionDaoCSV;

    public TestServiceImpl() {
    }

    public TestServiceImpl(QuestionDaoCSV questionDaoCSV) {

        this.questionDaoCSV = questionDaoCSV;
    }


    public QuestionDaoCSV getQuestionDaoCSV() {

        return questionDaoCSV;
    }

    public void setQuestionDaoCSV(QuestionDaoCSV questionDaoCSV) {

        this.questionDaoCSV = questionDaoCSV;
    }

    public List<Question> getQuestions(String fileName, String delimiter) {

        List<Question> questions = new ArrayList<>();

        try {

            questions = questionDaoCSV.getQuestionsFromFile(fileName, delimiter);

        } catch (IOException ioe) {
            System.out.println(READ_QUESTIONS_ERROR_MESSAGE);
            ioe.printStackTrace();
        }

        return questions;
    }

    public Person createPerson() {
        Scanner in = new Scanner(System.in);
        System.out.println(ENTER_FIRST_NAME_MESSAGE);
        String firstName = in.nextLine();

        System.out.println(ENTER_LAST_NAME_MESSAGE);
        String lastName = in.nextLine();

        return new Person(firstName, lastName);
    }


    protected int checkAnswers(List<Integer> givenAnswers, List<Integer> rightAnswers) {
        int result = 0;
        Iterator studAnswersIter = givenAnswers.iterator();
        Iterator rightAnswersIter = rightAnswers.iterator();
        for (; studAnswersIter.hasNext() && rightAnswersIter.hasNext(); ) {

            result += studAnswersIter.next().equals(rightAnswersIter.next()) ? 1 : 0;
        }
        return result;
    }

    protected void printQuestion(Question question) {

        StringBuilder questionMessage =
                new StringBuilder(QUESTION_NUMBER_MESSAGE)
                        .append(question.getQuestionNumber())
                        .append(":").append(lineSeparator())
                        .append(question.getQuestionText())
                        .append(lineSeparator())
                        .append(QUESTION_CHOICE_MESSAGE)
                        .append(lineSeparator());


        int answerNumber = 1;

        for (String answer : question.getAnswers()) {
            questionMessage.append(answerNumber++).append(". ")
                    .append(answer)
                    .append(lineSeparator());
        }

        questionMessage.append(QUESTION_ENTER_MESSAGE);
        System.out.println(questionMessage.toString());
    }


    public int doTest(Person person, List<Question> questions) {

        int score = 0;
        Scanner in = new Scanner(System.in);
        List<Integer> correctAnswers = new ArrayList<>();
        List<Integer> givenAnswers = new ArrayList<>();

        if (questions != null) {
            for (Question question : questions) {

                printQuestion(question);

                try {

                    givenAnswers.add(in.nextInt());
                } catch (Exception ex) {
                    System.out.println(ANSWER_INPUT_ERROR);
                }
                correctAnswers.add(question.getCorrectAnswerIndex());
            }

            score = checkAnswers(givenAnswers, correctAnswers);

        } else {
            System.out.println(EMPTY_QUESTIONS_ERROR);
        }

        return score;

    }

    public void printTestResult(Person person, int score, int questionsCount) {

        System.out.println(
                new StringBuilder(person.getFistName()).append(" ")
                        .append(person.getLastName()).append(", ")
                        .append(RESULT_MESSAGE1)
                        .append(" ").append(score).append(" ")
                        .append(RESULT_MESSAGE2).append(" ")
                        .append(questionsCount).append(".")
                        .toString());
    }

}