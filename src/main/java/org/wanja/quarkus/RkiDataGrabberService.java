package org.wanja.quarkus;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import org.wanja.quarkus.model.*;

@RegisterRestClient(configKey = "rki-api")
@Path("/")
public interface RkiDataGrabberService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RkiModel fetchAll();
}
