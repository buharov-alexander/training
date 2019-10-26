package ru.bukharov.training.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfig.class);
        /*
            1) LoggerBeanFactoryPostProcessor get all bean definitions

            2) Create bean "myHead"
                2.1) Constructor myHead
                2.2) LoggerBeanPostProcessor - before initialization myHead
                2.3) Post construct for myHead
                2.4) LoggerBeanPostProcessor - after initialization myHead

            3) Create bean "myPerson"
                3.1) Constructor myPerson
                3.2) LoggerBeanPostProcessor - before initialization myPerson
                3.3) Post construct for myPerson
                3.4) LoggerBeanPostProcessor - after initialization myPerson

            4) LoggerApplicationListener get ContextRefreshedEvent
         */
    }
}
