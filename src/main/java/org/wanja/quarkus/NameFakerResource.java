package org.wanja.quarkus;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.github.javafaker.Faker;

@Path("/faker")
@Produces(MediaType.TEXT_PLAIN)
public class NameFakerResource {
    
    @GET
    public String fake() {
        Faker f = new Faker();
        return f.ancient().hero()+"-"+f.app().name();
    }
}
