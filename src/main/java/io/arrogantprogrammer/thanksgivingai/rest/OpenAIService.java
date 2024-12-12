package io.arrogantprogrammer.thanksgivingai.rest;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.arrogantprogrammer.thanksgivingai.ai.OutputRelevanceGuardrail;
import io.arrogantprogrammer.thanksgivingai.ai.tools.EmailTool;
import io.arrogantprogrammer.thanksgivingai.api.MenuRecord;
import io.arrogantprogrammer.thanksgivingai.domain.MenuItemRepository;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrails;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService(tools = EmailTool.class)
@ApplicationScoped
public interface OpenAIService {

    @SystemMessage({
            "You are a chef specializing in local dishes and ingredients. You are creating a menu of finger foods for a Christmas cocktail party.",
    })
    @OutputGuardrails(OutputRelevanceGuardrail.class)
    @ToolBox(MenuItemRepository.class)
    MenuRecord createMenu(@UserMessage String userMessage);

}
