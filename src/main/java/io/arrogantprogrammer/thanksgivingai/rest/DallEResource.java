package io.arrogantprogrammer.thanksgivingai.rest;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/dalle")
public class DallEResource {

    @RestClient
    DallEService assistant;

    @ConfigProperty(name = "quarkus.langchain4j.openai.api-key")
    String apiKey;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String prompt(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("key: %s", apiKey);
        // feel free to update this message to any question you may have for the LLM.
        String prompt = "Create a fun and inviting Thanksgiving dinner invitation for friends and family that incorporates the following menu: " + createInvitationCommand.menuRecord().toString();
        DallERequestRecord requestRecord = new DallERequestRecord(
                "Create a fun and inviting Thanksgiving dinner invitation for friends and family that incorporates the following menu: " + createInvitationCommand.menuRecord().toString(),
                "2",
                "1024x1024");
        Log.debugf("requestRecord: %s", requestRecord);
        return assistant.createInvitation(requestRecord).toString();
    }
}
