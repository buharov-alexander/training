package ru.bukharov.training.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.bukharov.training.spring.bean.User;

@Component("sqliteUserDAO")
public class SQLiteUserDAO implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAndThrowException(long id) throws Exception {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        throw new Exception("Exception to test a transaction rollback");
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("from " + User.class.getName(), User.class).getResultList();
    }
}
