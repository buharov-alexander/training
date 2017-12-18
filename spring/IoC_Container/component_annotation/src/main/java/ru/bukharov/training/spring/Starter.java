package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person person = context.getBean(Person.class);
        System.out.println(String.format("Hello, I'm person configured by @Component: %s", person));

        System.out.println(String.format("I've got the head: %s", person.getHead()));
    }
}
