package org.wanja.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.wanja.quarkus.model.*;

@Path("/rki")
public class RkiDataGrabberResource {
    /*
    Reading JSON Data via 
    https://services7.arcgis.com/mOBPykOjAyBO2ZKk/arcgis/rest/services/RKI_Landkreisdaten/FeatureServer/0/query?where=1%3D1&outFields=OBJECTID,death_rate,cases,deaths,cases_per_100k,cases_per_population,BL,BL_ID,county,last_update,cases7_per_100k,EWZ_BL,cases7_bl_per_100k,cases7_bl,death7_bl,cases7_lk,death7_lk,cases7_per_100k_txt&returnGeometry=false&outSR=4326&f=json
    */

    @Inject
    @RestClient
    RkiDataGrabberService   dataGrabber;

    @GET
    public RkiModel fetch() {

        return dataGrabber.fetchAll();
    }

    
}