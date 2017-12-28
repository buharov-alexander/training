package ru.bukharov.training.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.bukharov.training.spring.bean.Person;

import java.util.List;

@Component("sqlitePersonDAO")
@Transactional
public class SQLitePersonDAO implements PersonDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer insert(Person person) {
        return (Integer) sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public void deleteById(Integer id) {
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        sessionFactory.getCurrentSession().delete(person);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) sessionFactory.getCurrentSession().createQuery("from " + Person.class.getName()).list();
    }
}
