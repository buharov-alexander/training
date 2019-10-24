package ru.bukharov.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bukharov.training.spring.bean.Head;
import ru.bukharov.training.spring.bean.Person;

@Configuration
public class AppConfig {

    @Bean
    public Person myPerson(Head head) {
        return new Person(head);
    }

    @Bean
    public Head myHead() {
        return new Head();
    }

    @Bean
    public LoggerBeanPostProcessor myBPP() {
        return new LoggerBeanPostProcessor();
    }

    @Bean
    public LoggerBeanFactoryPostProcessor myBFPP() {
        return new LoggerBeanFactoryPostProcessor();
    }

    @Bean
    public LoggerApplicationListener myAppListener() {
        return new LoggerApplicationListener();
    }
}
