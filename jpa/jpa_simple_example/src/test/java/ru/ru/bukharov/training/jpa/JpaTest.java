package ru.ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bukharov.training.jpa.EntityManagerUtil;
import ru.bukharov.training.jpa.MessageDao;
import ru.bukharov.training.jpa.domain.Message;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JpaTest {

    private static MessageDao dao;

    @BeforeAll
    static void setUp() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        dao = new MessageDao(em);
    }

    @BeforeEach
    void beforeEach() {
        dao.beginTransaction();
    }

    @AfterEach
    void afterEach() {
        dao.commitTransaction();
    }

    @Test
    void saveMessageTest() {
        Message message = new Message();
        message.setText("This message will be saved");
        message = dao.saveMessage(message);

        assertNotNull(message.getId());
    }

    @Test
    void getMessageTest() {
        Message message = new Message();
        message.setText("Step_1");
        message = dao.saveMessage(message);

        assertEquals("Step_1", message.getText());
        message.setText("Step_2");

        Message updatedMessage = dao.findById(message.getId());
        assertEquals("Step_2", updatedMessage.getText());
    }
}
