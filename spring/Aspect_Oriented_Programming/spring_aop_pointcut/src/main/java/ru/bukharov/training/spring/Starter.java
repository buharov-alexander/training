package ru.bukharov.training.spring;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import ru.bukharov.training.spring.advice.LoggerAdvice;
import ru.bukharov.training.spring.pointcut.NamePointcut;
import ru.bukharov.training.spring.service.Person;

public class Starter {
    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(new Person("Sasha"));
        Pointcut pointcut = new NamePointcut("sayBye");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new LoggerAdvice());
        pf.addAdvisor(advisor);
        Person proxy = (Person) pf.getProxy();

        String result = proxy.sayHello();
        System.out.println(result);

        System.out.println("----------------------");

        result = proxy.sayBye();
        System.out.println(result);
    }
}
