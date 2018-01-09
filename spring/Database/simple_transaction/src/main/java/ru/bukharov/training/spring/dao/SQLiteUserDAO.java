package ru.bukharov.training.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.bukharov.training.spring.bean.User;

import java.util.List;

@Component("sqliteUserDAO")
public class SQLiteUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public long create(User user) {
        return (long) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAndThrowException(long id) throws Exception {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
        throw new Exception("Exception to test a transaction rollback");
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from " + User.class.getName()).list();
    }
}
