package org.wanja.quarkus;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/reader")
public class RkiReaderResource {

    @ConfigProperty(name = "rki-api/mp-rest/url")
    private String baseURL;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String read() throws IOException {
        String body = HttpHandler.getInstance().readRkiModel(baseURL);
        //System.out.println(body);

        RkiModel model = Converter.fromJsonString(body);

        if (model != null) {
            Iterator<Feature> itr = model.getFeatures().iterator();
            Feature f;
            StringBuffer sb = new StringBuffer();
            NumberFormat intFormat = NumberFormat.getIntegerInstance();
            NumberFormat dec = NumberFormat.getNumberInstance();

            while(itr.hasNext() ){
                f = itr.next();
                Attributes attr = f.getAttributes();
                sb.append(attr.getCounty())
                    .append(" (")
                    .append(attr.getBl().toValue())
                    .append(")").append(" = (")
                    .append(intFormat.format(attr.getCases()))
                    .append(" / ")
                    .append(intFormat.format(attr.getDeaths()))
                    .append(" / ")
                    .append(dec.format(attr.getCases7BlPer100K()))
                    .append(" -- ").append(attr.getLastUpdate())
                    .append(")\n");
            } 

            return sb.toString();
        }
        return "DOES NOT WORK; DAMN!";
    }

}
