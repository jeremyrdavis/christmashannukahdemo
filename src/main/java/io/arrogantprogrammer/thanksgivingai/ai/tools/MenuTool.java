package io.arrogantprogrammer.thanksgivingai.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenuItem;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenuItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MenuTool {

    @Inject
    ThanksgivingMenuItemRepository repository;

    @Tool("find menu item by state")
    public List<ThanksgivingMenuItem> findMenuItemsByState(String state) {
        return repository.find("state", state).stream().toList();
    }

    @Tool("find menu item by region")
    public List<ThanksgivingMenuItem> findMenuItemsByRegion(String region) {
        return repository.find("region", region).stream().toList();
    }
}
