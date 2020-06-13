package com.example.demo;

import com.example.demo.config.MessageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        //*************************
        // работает spring-boot с подключением баннера из banner.txt и измененным портом на 8081
        //  в файле application.yml
       //SpringApplication.run(DemoApplication.class, args);


        //************************************
        // выдает ошибку: "Exception in thread "main" org.springframework.context.NoSuchMessageException:
        // No message found under code 'readQuestionError' for locale 'en_US'.
       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
        String mes = context.getMessage("enterFirstName", null, Locale.US);
        System.out.println(mes);

        Locale english = Locale.ENGLISH;
        Locale russian = new Locale("ru", "RU");

        System.out.println("-------------------Получение MessageSource из контекста--------------------------");

        System.out.println(context.getMessage("enterFirstName", null, english));
        System.out.println(context.getMessage("enterFirstName", null, russian));*/



        //**********************************
        //выдает ошибку: Exception in thread "main"
        // org.springframework.beans.factory.BeanDefinitionStoreException:
        // IOException parsing XML document from class path resource
        // [scr/main/resources/context.xml]; nested exception is java.io.FileNotFoundException:
        // class path resource [scr/main/resources/context.xml] cannot be opened because it does not exist
        //возиожно ошибка расположенна в этом месте в файле context.xml
        //<list>
        //                <value>buttons</value>
        //                <value>labels</value>
        //            </list>


  /*     GenericXmlApplicationContext context = new GenericXmlApplicationContext();
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
*/


//**************************************88
        //всё работает как работа изначально
      /*  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);

        TestService testService = context.getBean(TestService.class);

        List<Question> questions = testService.getQuestions(CSV_FILE_NAME, DELIMITER);
        int questionsCount = 0;
        if (questions != null) {
            questionsCount = questions.size();
        }

        Person person = testService.createPerson();
        int score = testService.doTest(person, questions);

        testService.printTestResult(person, score, questionsCount);

    }*/



        //****************************************************
        //все работает с выводом сообщений без изменения языка и с spring-context.xml файла

        /*MessageSource resources = new ClassPathXmlApplicationContext("spring-context.xml");

         String message1 = resources.getMessage("enterFirstName",null, Locale.US);
         System.out.println(message1);
        String message2 = resources.getMessage("enterLastName",null, Locale.US);
        System.out.println(message2);*/



    }
}