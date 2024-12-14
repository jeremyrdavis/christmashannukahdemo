package io.arrogantprogrammer.christmashannukah.ai;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.output.Response;
import io.arrogantprogrammer.christmashannukah.api.*;
import io.arrogantprogrammer.christmashannukah.domain.ChristmasMenu;
import io.arrogantprogrammer.christmashannukah.domain.FestivusMenu;
import io.arrogantprogrammer.christmashannukah.domain.HannukahMenu;
import io.arrogantprogrammer.christmashannukah.rest.OpenAIService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

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

    public Invitation createChristmasInvitation(final CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand);
        var image = imageModel.generate(ChristmasMenu.createInvitationPrompt(createInvitationCommand.menuRecord()));
        var uuid = getUuid(image);
        return new Invitation("/public/christmas/" + uuid + ".png", null);
    }

    public Invitation createHannukahInvitation(CreateInvitationCommand createInvitationCommand) {
        var image = imageModel.generate(HannukahMenu.createInvitationPrompt(createInvitationCommand.menuRecord()));
        var uuid = getUuid(image);
        return new Invitation("/public/hannukah/" + uuid + ".png", null);
    }

    public Invitation createFestivusInvitation(CreateInvitationCommand createInvitationCommand) {
        var image = imageModel.generate(FestivusMenu.createInvitationPrompt(createInvitationCommand.menuRecord()));
        var uuid = getUuid(image);
        return new Invitation("/public/festivus" + uuid + ".png", null);
    }

    private static @NotNull UUID getUuid(Response<Image> image) {
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
        return uuid;
    }

    public MenuRecord createMenu(CreateMenuCommand createMenuCommand) {
        String prompt = ChristmasMenu.createPrompt(createMenuCommand.stateCodes());
        MenuRecord result = openAIService.createMenu(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

    public MenuRecord createHannukahMenu(CreateMenuCommand createMenuCommand) {
        String prompt = HannukahMenu.createMenuPrompt();
        MenuRecord result = openAIService.createHannukahMenu(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

    public MenuRecord createFestivusMenu(CreateMenuCommand createMenuCommand) {
        String prompt = FestivusMenu.createPrompt();
        MenuRecord result = openAIService.createFestivusMenu(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }
}
