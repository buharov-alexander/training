package ru.bukharov.training.spring.bean;

import java.util.Random;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prototypeTicket")
@Scope("prototype")
public class Ticket {

    private int number;

    public Ticket() {
        this.number = new Random().nextInt(100);
    }

    @Override
    public String toString() {
        return String.format("Ticket {number: %s}", number);
    }
}
