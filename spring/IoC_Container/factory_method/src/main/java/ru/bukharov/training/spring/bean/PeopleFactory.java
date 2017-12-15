package ru.bukharov.training.spring.bean;

public class PeopleFactory {

    public People createPeople() {
        People people = new People();
        people.setName("People_created_by_factory");
        return people;
    }
}
