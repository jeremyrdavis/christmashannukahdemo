package io.arrogantprogrammer.christmashannukah.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/podman-ai")
public class PodmanAiResource {

    @Inject
    PodmanAiService assistant;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String prompt() {
        // feel free to update this message to any question you may have for the LLM.
        String message = "Create a Thanksgiving menu that combines traditional recipies with Georgia or southern specialties. The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. Each main, side, and dessert should have a name and a brief descr iption, for example, name: Turkey description: Citrus Brined and Roasted. Return the menu in the following json format: { \"mains\":[{\"item\": \"string\"}] ,\"sides\":[{\"item\":\"string\",\"description\":\"string\"}],\"desserts\":[{\"item\":string\",\"description\":\"string\"}]. Also include the the name of the model being used in the following json format, {\"model\":\"string\"}, and the stateCode in the following format, {\"stateCode\" : \"GA\"}. Return only json in the specified, valid format.";
        return assistant.chat(message);
    }
}
