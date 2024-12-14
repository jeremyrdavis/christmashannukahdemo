package io.arrogantprogrammer.christmashannukah.ai;

import dev.langchain4j.model.image.ImageModel;
import io.arrogantprogrammer.christmashannukah.api.*;
import io.arrogantprogrammer.christmashannukah.domain.ChristmasMenu;
import io.arrogantprogrammer.christmashannukah.domain.HannukahMenu;
import io.arrogantprogrammer.christmashannukah.rest.OpenAIService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@ApplicationScoped
public class AiService {

    @Inject
    OpenAIService openAIService;

    @Inject
    ImageModel imageModel;

    public Invitation createInvitation(final CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand);
        String prompt = ChristmasMenu.createInvitationPrompt(createInvitationCommand.menuRecord());

        var image = imageModel.generate(prompt);
        var uri = image.content().url();
        var desc = image.content().revisedPrompt();
        var uuid = UUID.randomUUID();
        var file = new File("src/main/webui/public/" + uuid + ".png");
        try {
            Files.copy(uri.toURL().openStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.debugf("file://" + file.getAbsolutePath());

        return new Invitation("/public/" + uuid + ".png", createInvitationCommand.menuRecord());
    }

    public MenuRecord createMenu(CreateMenuCommand createMenuCommand) {
        String prompt = ChristmasMenu.createPrompt(createMenuCommand.stateCodes());
        MenuRecord result = openAIService.createMenu(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

    public MenuRecord createHannukahMenu(CreateMenuCommand createMenuCommand) {
        String prompt = HannukahMenu.createPrompt();
        MenuRecord result = openAIService.createHannukahMenu(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }
}
