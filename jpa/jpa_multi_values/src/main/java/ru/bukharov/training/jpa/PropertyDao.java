package ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import ru.bukharov.training.jpa.domain.PropertyEntity;

public class PropertyDao {

    private EntityManager em;

    public PropertyDao(EntityManager em) {
        this.em = em;
    }

    public PropertyEntity saveItem(PropertyEntity property) {
        em.persist(property);
        return property;
    }

    public PropertyEntity findById(long id) {
        return em.find(PropertyEntity.class, id);
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }
}
