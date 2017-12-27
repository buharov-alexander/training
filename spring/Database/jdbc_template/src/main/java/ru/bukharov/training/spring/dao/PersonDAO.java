package ru.bukharov.training.spring.dao;

import ru.bukharov.training.spring.bean.Person;

import java.util.List;

public interface PersonDAO {

    void insert(Person person);

    void delete(int id);

    List<Person> findAll();

    Person findByName(String name);
}
