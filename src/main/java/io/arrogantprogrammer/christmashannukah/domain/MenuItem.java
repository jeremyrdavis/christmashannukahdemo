package io.arrogantprogrammer.christmashannukah.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem extends PanacheEntity {

    String item;

    String description;

    @Enumerated(EnumType.STRING)
    StateCodes state;

    @Enumerated(EnumType.STRING)
    USRegion region;

    protected MenuItem() {
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public StateCodes getState() {
        return state;
    }
}
