package ru.bukharov.training.spring.service;

public class Person implements Speaker {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        String message = String.format("Hello, I'm %s!", name);
        System.out.println(message);
        return message;
    }
}
