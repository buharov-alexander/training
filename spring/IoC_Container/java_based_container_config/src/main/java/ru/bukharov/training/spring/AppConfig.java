package ru.bukharov.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bukharov.training.spring.bean.Head;
import ru.bukharov.training.spring.bean.Person;

@Configuration
public class AppConfig {

    @Bean
    public Person myPerson() {
        return new Person();
    }

    @Bean
    public Head myHead() {
        return new Head();
    }
}
