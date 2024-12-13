package io.arrogantprogrammer.christmashannukah.rest;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService()
@SessionScoped
public interface PodmanAiService {

    @SystemMessage({
            "You are a Georgia chef specializing in local recipies and ingredients. You are preparing a Thanksgiving feast for your family and friends.",
    })
    String chat(@UserMessage String userMessage);
}
