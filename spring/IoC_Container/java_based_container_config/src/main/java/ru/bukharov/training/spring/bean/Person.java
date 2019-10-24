package ru.bukharov.training.spring.bean;

public class Person {

    private Head head;

    public Person(Head head) {
        this.head = head;
    }

    public Head getHead() {
        return head;
    }
}
