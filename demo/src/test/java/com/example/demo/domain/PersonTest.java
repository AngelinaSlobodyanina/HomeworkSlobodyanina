package com.example.demo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PersonTest {

    @Test
    void Person() {
        String expectedName = "Student";
        String expectedLastname = "Student";
        Person person = new Person(expectedName, expectedLastname);
        Assertions.assertEquals(expectedName, person.getFistName());
        Assertions.assertEquals(expectedLastname, person.getLastName());

    }
}