package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(String.format("I'm %s", person.getName()));
        System.out.println(String.format("I've got the list %s", person.getList().toString()));
        System.out.println(String.format("I've got the set %s", person.getSet().toString()));
        System.out.println(String.format("I've got the map %s", person.getMap().toString()));
        System.out.println(String.format("I've got the properties %s", person.getProperties().toString()));

    }
}
