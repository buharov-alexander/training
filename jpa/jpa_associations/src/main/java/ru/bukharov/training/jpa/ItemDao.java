package ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import ru.bukharov.training.jpa.domain.Item;

public class ItemDao {

    private EntityManager em;

    public ItemDao(EntityManager em) {
        this.em = em;
    }

    public Item saveItem(Item message) {
        em.persist(message);
        return message;
    }

    public Item findById(long id) {
        return em.find(Item.class, id);
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }
}
