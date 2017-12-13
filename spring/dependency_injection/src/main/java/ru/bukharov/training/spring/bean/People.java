package ru.bukharov.training.spring.bean;

public class People {

    private String name;
    private Head head;
    private Pants pants;

    public People(String name, Head head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Head getHead() {
        return head;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }
}
