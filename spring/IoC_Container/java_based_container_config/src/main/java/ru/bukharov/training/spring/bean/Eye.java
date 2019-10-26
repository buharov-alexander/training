package ru.bukharov.training.spring.bean;

import java.util.Random;

public class Eye {

    private String eyeColor;

    public Eye() {
        this.eyeColor = "Color_" + new Random().nextInt(100);;
    }

    @Override
    public String toString() {
        return String.format("{Eye: %s}", eyeColor);
    }
}
