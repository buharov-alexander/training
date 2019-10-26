package ru.bukharov.training.spring.bean;

public class Person {

    private Eye leftEye;
    private Eye rightEye;

    public Person(Eye leftEye, Eye rightEye) {
        this.leftEye = leftEye;
        this.rightEye = rightEye;
    }

    public Eye getLeftEye() {
        return leftEye;
    }

    public Eye getRightEye() {
        return rightEye;
    }

    @Override
    public String toString() {
        return String.format("Person{ leftEye = %s, rightEye = %s }", leftEye, rightEye);
    }
}
