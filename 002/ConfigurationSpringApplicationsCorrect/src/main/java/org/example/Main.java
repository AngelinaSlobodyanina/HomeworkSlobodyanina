package org.example;

//import org.example.domain.Message;
//import org.springframework.context.MessageSource;

import org.example.domain.Person;
import org.example.domain.Question;
import org.example.service.TestService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Configuration
@ComponentScan
public class Main {

    private static final String CSV_FILE_NAME = "src/main/resources/data.csv";
    private static final String DELIMITER = ";";

    public static void main(String[] args) throws IOException {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        TestService testService = context.getBean(TestService.class);

        List<Question> questions = testService.getQuestions(CSV_FILE_NAME, DELIMITER);
        int questionsCount = 0;
        if (questions != null) {
            questionsCount = questions.size();
        }

        Person person = testService.createPerson();
        int score = testService.doTest(person, questions);

        testService.printTestResult(person, score, questionsCount);

       /* AnnotationConfigApplicationContext context1= new AnnotationConfigApplicationContext(Main.class);
        String mes =context1.getMessage("message.readQuestionError",null,Locale.ENGLISH);
        System.out.println(mes);*/

        //ReloadableResourceBundleMessageSource context1= new ReloadableResourceBundleMessageSource();

        //MessageSource message=context.getBean("messageSource",Message.class);
        //MessageSource message = context1.MESSAGE_SOURCE_BEAN_NAME("messageSource",Message.class)

        //System.out.println(message.getMessage("message.readQuestionError",null,Locale.ENGLISH));


        //MessageSource resources = new ClassPathXmlApplicationContext("spring-context.xml");
        //AnnotationConfigApplicationContext resources=new AnnotationConfigApplicationContext(Main.class);
        //MessageSource m=resources.getBean(MessageSource.class);
        // String message = resources.getMessage("enterFirstName",null, Locale.US);
        // System.out.println(message);

    }
}