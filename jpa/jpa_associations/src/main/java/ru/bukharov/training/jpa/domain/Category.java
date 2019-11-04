package ru.bukharov.training.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "categories")
    private Set<Item> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Set<Item> getItems() {
        return items;
    }

    void addItem(Item item) {
        items.add(item);
    }
}
