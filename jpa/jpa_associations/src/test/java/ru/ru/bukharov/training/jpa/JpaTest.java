package ru.ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import java.util.Collections;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bukharov.training.jpa.EntityManagerUtil;
import ru.bukharov.training.jpa.ItemDao;
import ru.bukharov.training.jpa.domain.Bid;
import ru.bukharov.training.jpa.domain.Category;
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

    @AfterAll
    static void close() {
        EntityManagerUtil.getEntityManager().close();
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
    void saveItemWithBidTest() {
        Item item = new Item();
        Bid bid = new Bid();
        item.addBids(bid);
        item = dao.saveItem(item);

        Item savedItem = dao.findById(item.getId());

        assertNotNull(savedItem.getId());
        assertEquals(1, savedItem.getBids().size(), "Item should contain 1 bid");
        assertNotNull(savedItem.getBids().iterator().next().getId());
    }

    // Save ManyToMany association
    @Test
    void saveItemWithCategoriesTest() {
        Item item1 = new Item();
        Category category1 = new Category();
        Category category2 = new Category();
        item1.addCategory(category1);
        item1.addCategory(category2);
        item1 = dao.saveItem(item1);


        Item item2 = new Item();
        Category category3 = new Category();
        item2.addCategory(category3);
        item2 = dao.saveItem(item2);

        Item savedItem1 = dao.findById(item1.getId());
        Item savedItem2 = dao.findById(item2.getId());

        assertNotNull(savedItem1.getId());
        assertEquals(2, savedItem1.getCategories().size(), "Item should contain 2 categories");
        assertNotNull(savedItem2.getId());
        assertEquals(1, savedItem2.getCategories().size(), "Item should contain 2 categories");
    }
}
