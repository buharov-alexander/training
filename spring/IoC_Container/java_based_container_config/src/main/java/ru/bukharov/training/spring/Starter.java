package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bukharov.training.spring.bean.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person firstPerson = context.getBean("firstPerson", Person.class);
        System.out.println(String.format("Hello, I'm java-based configured person: %s", firstPerson));

        System.out.println(String.format("I've got the SAME singleton eyes: %s and %s", firstPerson.getLeftEye(), firstPerson.getRightEye()));

        System.out.println("------------");

        Person secondPerson = context.getBean("secondPerson", Person.class);
        System.out.println(String.format("I'm java-based configured person: %s", secondPerson));
        System.out.println(String.format("I've got the DIFFERENT prototype eyes: %s and %s", secondPerson.getLeftEye(), secondPerson.getRightEye()));
    }
}
