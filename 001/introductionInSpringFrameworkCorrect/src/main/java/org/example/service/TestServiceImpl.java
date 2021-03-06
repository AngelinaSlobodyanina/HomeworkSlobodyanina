package org.example.service;

import org.example.dao.QuestionDao;
import org.example.domain.Person;
import org.example.domain.Question;

import java.io.IOException;
import java.util.*;

import static java.lang.System.lineSeparator;

public class TestServiceImpl implements TestService {

    private static final String READ_QUESTIONS_ERROR_MESSAGE = "Can not read questions data from the input file.";
    private static final String ENTER_FIRST_NAME_MESSAGE = "Enter your First Name:";
    private static final String ENTER_LAST_NAME_MESSAGE = "Enter your Last Name:";

    private static final String RESULT_MESSAGE1 = "You have";
    private static final String RESULT_MESSAGE2 = "correct answer(s) of";

    private static final String QUESTION_NUMBER_MESSAGE = "Question #";
    private static final String QUESTION_CHOICE_MESSAGE = "Please select only one correct answer:";
    private static final String QUESTION_ENTER_MESSAGE = "Enter correct answer number: ";

    private static final String ANSWER_INPUT_ERROR = "Incorrect answer format.";
    private static final String EMPTY_QUESTIONS_ERROR = "No questions found.";


    private QuestionDao questionDao;

    public TestServiceImpl() {
    }

    public TestServiceImpl(QuestionDao questionDao) {

        this.questionDao = questionDao;
    }


    public QuestionDao getQuestionDao() {

        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {

        this.questionDao = questionDao;
    }

    public List<Question> getQuestions(String fileName, String delimiter) {

        List<Question> questions = new ArrayList<>();
        try {

            questions = questionDao.getQuestionsFromFile(fileName, delimiter);

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