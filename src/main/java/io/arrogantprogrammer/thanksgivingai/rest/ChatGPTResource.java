package io.arrogantprogrammer.thanksgivingai.rest;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("chatgpt")
public class ChatGPTResource {

    @Inject
    OpenAIService assistant;

    @ConfigProperty(name = "quarkus.langchain4j.openai.api-key")
    String apiKey;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String prompt() {
        Log.debugf("key: %s", apiKey);
        // feel free to update this message to any question you may have for the LLM.
        String message = "Create a Thanksgiving menu that combines traditional recipes with Georgia or southern specialties. The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. Each main, side, and dessert should have a name and a brief descr iption, for example, name: Turkey description: Citrus Brined and Roasted. Return the menu in the following json format: { \"mains\":[{\"item\": \"string\"}] ,\"sides\":[{\"item\":\"string\",\"description\":\"string\"}],\"desserts\":[{\"item\":string\",\"description\":\"string\"}]. Also include the the name of the model being used in the following json format, {\"model\":\"string\"}, and the stateCode in the following format, {\"stateCode\" : \"GA\"}. Return only json in the specified, valid format.";
        return assistant.chat(message).toString();
    }
}
