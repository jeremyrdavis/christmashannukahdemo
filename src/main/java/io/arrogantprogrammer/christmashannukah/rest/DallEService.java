package io.arrogantprogrammer.christmashannukah.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://api.openai.com")
@Path("/v1/images/generations")
public interface DallEService {

    @GET
    String createInvitation(DallERequestRecord prompt);
}
