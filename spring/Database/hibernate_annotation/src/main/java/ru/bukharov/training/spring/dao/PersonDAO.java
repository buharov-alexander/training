package ru.bukharov.training.spring.dao;

import ru.bukharov.training.spring.bean.Person;

import java.util.List;

public interface PersonDAO {

    Integer insert(Person person);
    void deleteById(Integer id);
    List<Person> findAll();
}
