package io.arrogantprogrammer.thanksgivingai.ai;

import dev.langchain4j.model.image.ImageModel;
import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.rest.OpenAIService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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

    public ThanksgivingInvitation createInvitation(final ThanksgivingMenuRecord thanksgivingMenuRecord) {
        Log.debugf("Creating invitation for %s", thanksgivingMenuRecord);
        String prompt = ThanksgivingMenu.createInvitationPrompt(thanksgivingMenuRecord);

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

        return new ThanksgivingInvitation("/public/" + uuid + ".png", thanksgivingMenuRecord);
    }

    public ThanksgivingMenuRecord createMenu(CreateMenuCommand createMenuCommand) {
        String prompt = ThanksgivingMenu.createPrompt(createMenuCommand.stateCodes());
        ThanksgivingMenuRecord result = openAIService.chat(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

}
