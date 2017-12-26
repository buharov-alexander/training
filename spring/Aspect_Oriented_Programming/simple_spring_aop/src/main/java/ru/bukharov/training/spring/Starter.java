package ru.bukharov.training.spring;

import org.springframework.aop.framework.ProxyFactory;
import ru.bukharov.training.spring.advice.LoggerAdvice;
import ru.bukharov.training.spring.service.Person;
import ru.bukharov.training.spring.service.Speaker;

public class Starter {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(new Person("Sasha"));
        pf.addAdvice(new LoggerAdvice());
        Person cglibProxyPerson = (Person) pf.getProxy();

        String result = cglibProxyPerson.sayHello();
        System.out.println(String.format("I'm CGLIB proxy: %s", cglibProxyPerson.getClass().getName()));
        System.out.println(result);

        System.out.println("--------------------------------------");

        pf.addInterface(Speaker.class);
        Speaker jdkProxyPerson = (Speaker) pf.getProxy();
        result = jdkProxyPerson.sayHello();
        System.out.println(String.format("I'm JDK proxy: %s", jdkProxyPerson.getClass().getName()));
        System.out.println(result);
    }
}
