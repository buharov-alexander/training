package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.People;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        People people = (People) context.getBean("sasha");
        System.out.println(String.format("Hello, I'm %s", people.getName()));

        System.out.println(String.format("I've got the %s head from constructor", people.getHead().getHairColor()));
        System.out.println(String.format("and the %s pants from setter.", people.getPants().getColor()));
    }
}
