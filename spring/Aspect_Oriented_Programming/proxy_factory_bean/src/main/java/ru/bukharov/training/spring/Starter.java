package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.service.Person;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Person proxy = (Person) context.getBean("proxyPerson");
        System.out.println(String.format("We got proxy of person %s, class %s",
                proxy.getName(), proxy.getClass().getName()));

        String result = proxy.sayHello();
        System.out.println(result);

        System.out.println("----------------------");

        result = proxy.sayBye();
        System.out.println(result);
    }
}
