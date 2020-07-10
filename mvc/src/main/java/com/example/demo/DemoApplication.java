package com.example.demo;

import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    public static void main(String[] args) throws Exception {
       // ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class);
        SpringApplication.run(DemoApplication.class);

    }


    @PostConstruct
    public void init() throws Exception {
        authorService.deleteAll();
        bookService.deleteAll();
        authorService.add("Arthur", "Conan Doyle");
        authorService.add("Agatha", "Christie");
        authorService.add("Luc", "Besson");
        authorService.add("Christie", "Golden");
        bookService.add("Sherlock Holmes","978-5-907120-60-0");
        bookService.add("Professor Challenger","978-5-8475-1121-6");
        bookService.add("Murder on the Orient Express","978-5-04-098115-1");
        bookService.add("Ten Little Niggers","978-5-9925-0837-6");
        bookService.add("Poirot Investigates","978-5-04-107820-1");
        bookService.add("Arthur and minipyts","978-90225-43-009");
        bookService.add("'World of Warcraft","978-5-17-112285-0");
    }

}