package org.wanja.quarkus;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.wanja.quarkus.model.*;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("report")
public class RkiReportResource {
   
    @ConfigProperty(name = "rki-api/mp-rest/url")
    private String baseURL;
    
    @Inject
    Template rkiReport;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance list() throws IOException {
        RkiModel model = Converter.fromJsonString(HttpHandler.getInstance().readRkiModel(baseURL));
        return rkiReport.data("list", model.getFeatures());
    }
}
