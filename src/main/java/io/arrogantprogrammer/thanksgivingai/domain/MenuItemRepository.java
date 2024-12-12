package io.arrogantprogrammer.thanksgivingai.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MenuItemRepository implements PanacheRepository<MenuItem> {
}
