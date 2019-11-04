package ru.ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bukharov.training.jpa.EntityManagerUtil;
import ru.bukharov.training.jpa.ItemDao;
import ru.bukharov.training.jpa.domain.Bid;
import ru.bukharov.training.jpa.domain.Item;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JpaTest {

    private static ItemDao dao;

    @BeforeAll
    static void setUp() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        dao = new ItemDao(em);
    }

    @BeforeEach
    void beforeEach() {
        dao.beginTransaction();
    }

    @AfterEach
    void afterEach() {
        dao.commitTransaction();
    }

    // Save OneToMany association
    @Test
    void saveItemTest() {
        Item item = new Item();
        Bid bid = new Bid();
        item.addBids(bid);
        item = dao.saveItem(item);

        Item savedItem = dao.findById(item.getId());

        assertNotNull(savedItem.getId());
        assertEquals(1, savedItem.getBids().size(), "Item should contain 1 bid");
        assertNotNull(savedItem.getBids().iterator().next().getId());
    }
}
