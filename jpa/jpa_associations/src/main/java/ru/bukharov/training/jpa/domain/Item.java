package ru.bukharov.training.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Set<Bid> bids = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void addBids(Bid bid) {
        bids.add(bid);
        bid.setItem(this);
    }
}
