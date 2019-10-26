package ru.bukharov.training.spring.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Person {

    @Lookup("prototypeTicket")
    public abstract Ticket getTicket();

    public void say() {
        System.out.println(String.format("Now I have %s", getTicket()));
    }
}
