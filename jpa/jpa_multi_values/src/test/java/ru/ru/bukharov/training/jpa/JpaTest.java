package ru.ru.bukharov.training.jpa;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bukharov.training.jpa.EntityManagerUtil;
import ru.bukharov.training.jpa.PropertyDao;
import ru.bukharov.training.jpa.domain.PropertyEntity;
import ru.bukharov.training.jpa.domain.PropertyMultiValueEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JpaTest {

	private static PropertyDao dao;

	@BeforeAll
	static void setUp() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		dao = new PropertyDao(em);
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

	// Save ManyToMany association
	@Test
	void saveProperty() {
		PropertyEntity property = new PropertyEntity();
		property.setName("Property name 1");

		PropertyMultiValueEntity value1 = new PropertyMultiValueEntity();
		value1.setValue("red");
		PropertyMultiValueEntity value2 = new PropertyMultiValueEntity();
		value2.setValue("blue");

		List<PropertyMultiValueEntity> list = new ArrayList<>();
		list.add(value1);
		list.add(value2);
		property.setMultiSelectValues(list);
		property = dao.saveItem(property);

		PropertyEntity savedProperty = dao.findById(property.getId());

		assertNotNull(savedProperty.getId());
	}
}
