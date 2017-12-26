package ru.bukharov.training.spring.service;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello() {
        String message = String.format("Hello, I'm %s!", name);
        System.out.println(message);
        return message;
    }

    public String sayBye() {
        String message = String.format("Goodbye, I'm %s!", name);
        System.out.println(message);
        return message;
    }
}
