package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.mixin.PhraseTracked;
import ru.bukharov.training.spring.service.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person person = (Person) context.getBean("sasha");
        System.out.println(String.format("We got person %s, class %s",
                person.getName(), person.getClass().getName()));

        person.sayHello();
        System.out.println("----------------------");

        person.sayBye();
        System.out.println("----------------------");

        System.out.println(String.format("Person is PhraseTracked: %b", person instanceof PhraseTracked));
        System.out.println(String.format("Person counter: %d", ((PhraseTracked)person).count()));
    }
}
