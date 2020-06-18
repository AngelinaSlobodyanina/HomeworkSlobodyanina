package com.example.demo005;

import com.example.demo005.config.MessageConfig;
import com.example.demo005.dao.MessageDaoPropertiesImpl;
import com.example.demo005.domain.Person;
import com.example.demo005.domain.Question;
import com.example.demo005.service.MessageLocale;
import com.example.demo005.service.TestService;
import org.jline.utils.AttributedStyle;
import org.jline.utils.AttributedString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.shell.jline.PromptProvider;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo005"})
//@EnableConfigurationProperties(MessageDaoPropertiesImpl.class)
public class Demo005Application {

    @Autowired
    private TestService testService;
    //private MessageLocale messageLocale;


    private static final String CSV_FILE_NAME = "src/main/resources/data.csv";
    private static final String DELIMITER = ";";

    public static void main(String[] args) throws IOException {

        //*************************
        // работает spring-boot
        SpringApplication.run(Demo005Application.class, args);
        //************************************88
        // выдает ошибку: "Exception in thread "main" org.springframework.context.NoSuchMessageException:
        // No message found under code 'readQuestionError' for locale 'en_US'.
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
        String mes = context.getMessage("readQuestionError", null, Locale.US);
        System.out.println(mes);
        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru", "RU");
        System.out.println("-------------------Получение MessageSource из контекста--------------------------");
        System.out.println(context.getMessage("readQuestionError", null, english));
        System.out.println(context.getMessage("readQuestionError", null, russian));*/


        //**********************************
        //выдает ошибку: Exception in thread "main"
        // org.springframework.beans.factory.BeanDefinitionStoreException:
        // IOException parsing XML document from class path resource
        // [scr/main/resources/context.xml]; nested exception is java.io.FileNotFoundException:
        // class path resource [scr/main/resources/context.xml] cannot be opened because it does not exist
       /*GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:scr/main/resources/context.xml");
        context.refresh();
        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru", "RU");
        System.out.println("-------------------Получение MessageSource из контекста--------------------------");
        System.out.println(context.getMessage("msg", null, english));
        System.out.println(context.getMessage("msg", null, russian));
        System.out.println(context.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, english));
        System.out.println(context.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, russian));
        //----------Получаем доступ к бину ResourceBundleMessageSource-------------
        System.out.println("---------------------------Лукап ResourceBundleMessageSource-------------------------------");
        MessageSource messageSource = (MessageSource) context.getBean("messageSource");
        System.out.println(messageSource.getMessage("msg", null, english));
        System.out.println(messageSource.getMessage("msg", null, russian));
        System.out.println(messageSource.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, english));
        System.out.println(messageSource.getMessage("nameMsg", new Object[] { "Name1", "Name2"}, russian));
    }*/
//**************************************88
        //всё работает как работа изначально
      /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
        TestService testService = context.getBean(TestService.class);
        List<Question> questions = testService.getQuestions(CSV_FILE_NAME, DELIMITER);
        int questionsCount = 0;
        if (questions != null) {
            questionsCount = questions.size();
        }
        Person person = testService.createPerson();
        int score = testService.doTest(person, questions);
        testService.printTestResult(person, score, questionsCount);
*/

    }
    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("shell:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }
    @Bean
    public CommandLineRunner runATest(ApplicationContext ctx) {
        return args -> {

            List<Question> questions = testService.getQuestions(CSV_FILE_NAME, DELIMITER);
            int questionsCount = 0;
            if (questions != null) {
                questionsCount = questions.size();
            }



            Person person = testService.createPerson();
            int score = testService.doTest(person, questions);

            testService.printTestResult(person, score, questionsCount);
        };
    }

}
