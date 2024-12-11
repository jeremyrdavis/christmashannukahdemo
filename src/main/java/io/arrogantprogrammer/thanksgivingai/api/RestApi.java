package io.arrogantprogrammer.thanksgivingai.api;

import io.arrogantprogrammer.thanksgivingai.ai.AiService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URL;

@Path("/ai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestApi {

    @Inject
    AiService aiService;

    @POST
    @Path("/invitation")
    public Response createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenuRecord());
        ThanksgivingInvitation thanksgivingInvitation = aiService.createInvitation(createInvitationCommand.thanksgivingMenuRecord());
        Log.debugf("Created %s for %s", thanksgivingInvitation, createInvitationCommand);
        return Response.ok(thanksgivingInvitation).build();
    }

    @POST
    @Path("/menu")
    public Response createMenu(CreateMenuCommand createMenuCommand) {
        Log.debugf("Creating menu for %s", createMenuCommand);
        ThanksgivingMenuRecord thanksgivingMenuRecord = aiService.createMenu(createMenuCommand);
        Log.debugf("Created %s for %s", thanksgivingMenuRecord, createMenuCommand);
        return Response.ok().entity(thanksgivingMenuRecord).build();
    }

}
