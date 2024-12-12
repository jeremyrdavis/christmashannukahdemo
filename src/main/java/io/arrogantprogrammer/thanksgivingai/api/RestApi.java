package io.arrogantprogrammer.thanksgivingai.api;

import io.arrogantprogrammer.thanksgivingai.ai.AiService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestApi {

    @Inject
    AiService aiService;

    @POST
    @Path("/invitation")
    public Response createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.menuRecord());
        Invitation invitation = aiService.createInvitation(createInvitationCommand);
        Log.debugf("Created %s for %s", invitation, createInvitationCommand);
        return Response.ok(invitation).build();
    }

    @POST
    @Path("/menu")
    public Response createMenu(CreateMenuCommand createMenuCommand) {
        Log.debugf("Creating menu for %s", createMenuCommand);
        MenuRecord menuRecord = aiService.createMenu(createMenuCommand);
        Log.debugf("Created %s for %s", menuRecord, createMenuCommand);
        return Response.ok().entity(menuRecord).build();
    }

}
