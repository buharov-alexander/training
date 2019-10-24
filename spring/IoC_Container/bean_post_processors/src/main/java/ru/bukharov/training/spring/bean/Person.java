package ru.bukharov.training.spring.bean;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;

public class Person {

    private final static Logger logger = Logger.getLogger(Person.class);

    private Head head;

    public Person(Head head) {
        logger.info("Create bean myPerson");
        logger.info("----------");
        logger.info("Constructor");
        this.head = head;
    }

    @PostConstruct
    public void init() {
        logger.info("Post construct");
    }

    public Head getHead() {
        return head;
    }
}
