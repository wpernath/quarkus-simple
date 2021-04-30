package org.wanja.quarkus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class HttpHandler {

    public static HttpHandler getInstance() {
        return new HttpHandler();
    }


    private final ExecutorService service = Executors.newFixedThreadPool(5);
    private final HttpClient client = HttpClient.newBuilder().executor(service).version(HttpClient.Version.HTTP_2)
            .build();

    public String readRkiModel(String where) throws IOException {
        HttpResponse body;
        try {
            body = client.send(HttpRequest.newBuilder().GET().uri(URI.create(where)).header("Accept", MediaType.APPLICATION_JSON).build(), HttpResponse.BodyHandlers.ofString());
            return body.body().toString();
        } 
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "404/Not FOund";
    }
}
