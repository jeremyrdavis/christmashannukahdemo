package io.arrogantprogrammer.christmashannukah.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import io.arrogantprogrammer.christmashannukah.domain.MenuItem;
import io.arrogantprogrammer.christmashannukah.domain.MenuItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MenuTool {

    @Inject
    MenuItemRepository repository;

    @Tool("find menu item by state")
    public List<MenuItem> findMenuItemsByState(String state) {
        return repository.find("state", state).stream().toList();
    }

    @Tool("find menu item by region")
    public List<MenuItem> findMenuItemsByRegion(String region) {
        return repository.find("region", region).stream().toList();
    }
}
