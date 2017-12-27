package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.Person;
import ru.bukharov.training.spring.dao.PersonDAO;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        PersonDAO personDAO = (PersonDAO) context.getBean("sqlitePersonDAO");

        Person person = new Person();
        person.setName("Sasha");

        System.out.println(String.format("Create a person with name: %s", person.getName()));
        personDAO.insert(person);
        System.out.println(String.format("Find all: %s", personDAO.findAll()));


        person = personDAO.findByName(person.getName());
        System.out.println(String.format("Delete the person with id: %s", person.getId()));
        personDAO.delete(person.getId());
        System.out.println(String.format("Find all: %s", personDAO.findAll()));

    }
}
