package com.example.demo005.service;

import com.example.demo005.dao.QuestionDaoCSV;
import com.example.demo005.domain.Person;
import com.example.demo005.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.Locale;

import static java.lang.System.lineSeparator;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private MessageLocale locale;
   // private TestService service;
    //private Locale someLocale =service.whatTheLocale();



    private static final String READ_QUESTIONS_ERROR_KEY = "ReadQuestion.Error";//"Can not read questions data from the input file.";
    private static final String ENTER_FIRST_NAME_KEY = "EnterFirstName.Message";//"Enter your First Name:";
    private static final String ENTER_LAST_NAME_KEY = "EnterLastName.Message";//"Enter your Last Name:";

    private static final String RESULT_KEY1 = "Result.Message1";//"You have";
    private static final String RESULT_KEY2 = "Result.Message2";//"correct answer(s) of";

    private static final String QUESTION_NUMBER_KEY = "QuestionNumber.Message";//"Question #";
    private static final String QUESTION_CHOICE_KEY = "QuestionChoice.Message";//"Please select only one correct answer:";
    private static final String QUESTION_ENTER_KEY = "QuestionEnter.Message";//"Enter correct answer number: ";

    private static final String ANSWER_INPUT_ERROR_KEY = "AnswerInput.Error";//"Incorrect answer format.";
    private static final String EMPTY_QUESTIONS_ERROR_KEY = "EmptyQuestion.Error";//"No questions found.";

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
            System.out.println(locale.message(READ_QUESTIONS_ERROR_KEY));
            ioe.printStackTrace();
        }

        return questions;
    }

    public Person createPerson() {
        Scanner in = new Scanner(System.in);
        System.out.println(locale.message(ENTER_FIRST_NAME_KEY));
        String firstName = in.nextLine();

        System.out.println(locale.message(ENTER_LAST_NAME_KEY));
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
                new StringBuilder(locale.message(QUESTION_NUMBER_KEY))
                        .append(question.getQuestionNumber())
                        .append(":").append(lineSeparator())
                        .append(question.getQuestionText())
                        .append(lineSeparator())
                        .append(locale.message(QUESTION_CHOICE_KEY))
                        .append(lineSeparator());


        int answerNumber = 1;

        for (String answer : question.getAnswers()) {
            questionMessage.append(answerNumber++).append(". ")
                    .append(answer)
                    .append(lineSeparator());
        }

        questionMessage.append(locale.message(QUESTION_ENTER_KEY));
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
                    System.out.println(locale.message(ANSWER_INPUT_ERROR_KEY));
                }
                correctAnswers.add(question.getCorrectAnswerIndex());
            }

            score = checkAnswers(givenAnswers, correctAnswers);

        } else {
            System.out.println(locale.message(EMPTY_QUESTIONS_ERROR_KEY));
        }

        return score;

    }

    public void printTestResult(Person person, int score, int questionsCount) {

        System.out.println(
                new StringBuilder(person.getFistName()).append(" ")
                        .append(person.getLastName()).append(", ")
                        .append(locale.message(RESULT_KEY1))
                        .append(" ").append(score).append(" ")
                        .append(locale.message(RESULT_KEY2)).append(" ")
                        .append(questionsCount).append(".")
                        .toString());
    }
    /*public Locale whatTheLocale(){
        Scanner in = new Scanner(System.in);
        String temp;
        do {
            System.out.println("Enter locale 'ru' or 'en' ");
            temp = in.nextLine();
            if (temp == "en")
                return java.util.Locale.ENGLISH;
                //return new java.util.Locale("en", "EN");
            else if (temp == "ru")
                return new java.util.Locale("ru", "RU");
            //nativeLocale = new java.util.Locale("ru", "RU");
        }while(temp=="en" ||temp=="ru");
        return Locale.ENGLISH;
    }*/
}