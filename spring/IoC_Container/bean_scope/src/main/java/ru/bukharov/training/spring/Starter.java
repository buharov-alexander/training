package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person singletonPerson = (Person) context.getBean("singletonPerson");
        System.out.println(String.format("Hello, I'm %s", singletonPerson.getName()));
        Person singletonPerson2 = (Person) context.getBean("singletonPerson");
        System.out.println(String.format("And, I'm %s, we are equal: %b", singletonPerson.getName(), singletonPerson == singletonPerson2));

        Person prototypePerson = (Person) context.getBean("prototypePerson");
        System.out.println(String.format("Hello, I'm %s", prototypePerson.getName()));
        Person prototypePerson2 = (Person) context.getBean("prototypePerson");
        System.out.println(String.format("And, I'm %s, we are equal: %b", prototypePerson.getName(), prototypePerson == prototypePerson2));
    }
}
