package ru.bukharov.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.bukharov.training.spring.bean.Eye;
import ru.bukharov.training.spring.bean.Person;

@Configuration
public class AppConfig {

    @Bean
    public Person firstPerson() {
        return new Person(singletonEye(), singletonEye());
    }

    @Bean
    public Person secondPerson() {
        return new Person(prototypeEye(), prototypeEye());
    }

    @Bean
    public Eye singletonEye() {
        return new Eye();
    }

    @Bean
    @Scope("prototype")
    public Eye prototypeEye() {
        return new Eye();
    }
}
