package ru.bukharov.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bukharov.training.spring.bean.Account;
import ru.bukharov.training.spring.bean.User;
import ru.bukharov.training.spring.dao.UserDAO;

import java.util.ArrayList;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        UserDAO userDAO = (UserDAO) context.getBean("sqliteUserDAO");

        Account bankAccount = new Account();
        bankAccount.setName("bank");
        Account brokerAccount = new Account();
        brokerAccount.setName("broker");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(bankAccount);
        accounts.add(brokerAccount);

        User user = new User();
        user.setLogin("Sasha");
        user.setAccounts(accounts);

        System.out.println(String.format("Create a user with name: %s", user.getLogin()));
        userDAO.create(user);
        System.out.println(String.format("Find all: %s", userDAO.findAll()));

        try {
            System.out.println(String.format("Delete the user with id: %s", user.getId()));
            userDAO.deleteAndThrowException(user.getId());
        } catch (Exception e) {
            System.out.println(String.format("Exception was thrown: %s", e.getMessage()));
        }
        System.out.println(String.format("Deleting have to be rollbacked. Find all: %s", userDAO.findAll()));

        System.out.println(String.format("Delete the user with id: %s", user.getId()));
        userDAO.deleteById(user.getId());
        System.out.println(String.format("Find all: %s", userDAO.findAll()));

    }
}
