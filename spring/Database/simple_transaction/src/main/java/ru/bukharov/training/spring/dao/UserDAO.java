package ru.bukharov.training.spring.dao;

import ru.bukharov.training.spring.bean.User;

import java.util.List;

public interface UserDAO {

    long create(User user);
    void deleteAndThrowException(long id) throws Exception;
    void deleteById(long id);
    List<User> findAll();
}
