package ru.bukharov.training.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Head {

    private String hairColor;

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
