package io.arrogantprogrammer.christmashannukah.api;

import io.arrogantprogrammer.christmashannukah.ai.AiService;
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
        if(createInvitationCommand.holiday().equals(HOLIDAY.CHRISTMAS)){
            Invitation invitation = aiService.createChristmasInvitation(createInvitationCommand);
            Log.debugf("Created %s for %s", invitation, createInvitationCommand);
            return Response.ok(invitation).build();
        }else if(createInvitationCommand.holiday().equals(HOLIDAY.HANNUKAH)){
            Invitation invitation = aiService.createHannukahInvitation(createInvitationCommand);
            Log.debugf("Created %s for %s", invitation, createInvitationCommand);
            return Response.ok(invitation).build();
        }else if (createInvitationCommand.holiday().equals(HOLIDAY.FESTIVUS)) {
            Invitation invitation = aiService.createFestivusInvitation(createInvitationCommand);
            Log.debugf("Created %s for %s", invitation, createInvitationCommand);
            return Response.ok(invitation).build();
        }else{
            Log.errorf("Invalid holiday %s", createInvitationCommand.holiday());
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid holiday").build();
        }
    }

    @POST
    @Path("/menu")
    public Response createMenu(CreateMenuCommand createMenuCommand) {

        Log.debugf("Creating menu for %s", createMenuCommand);

        if (createMenuCommand.holiday().equals(HOLIDAY.CHRISTMAS)) {
            MenuRecord menuRecord = aiService.createMenu(createMenuCommand);
            return Response.ok(menuRecord).build();
        }else if (createMenuCommand.holiday().equals(HOLIDAY.HANNUKAH)) {
            MenuRecord menuRecord = aiService.createHannukahMenu(createMenuCommand);
            return Response.ok(menuRecord).build();
        }else if (createMenuCommand.holiday().equals(HOLIDAY.FESTIVUS)) {
            MenuRecord menuRecord = aiService.createFestivusMenu(createMenuCommand);
            return Response.ok(menuRecord).build();
        }else{
            Log.errorf("Invalid holiday %s", createMenuCommand.holiday());
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid holiday").build();
        }
    }

}
