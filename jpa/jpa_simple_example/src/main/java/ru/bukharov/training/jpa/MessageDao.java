package ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import ru.bukharov.training.jpa.domain.Message;

public class MessageDao {

    private EntityManager em;

    public MessageDao(EntityManager em) {
        this.em = em;
    }

    public Message saveMessage(Message message) {
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
        return message;
    }

    public Message findById(long id) {
        return em.find(Message.class, id);
    }
}
