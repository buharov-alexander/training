package ru.bukharov.training.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    @Autowired
    private Head head;

    public Head getHead() {
        return head;
    }
}
