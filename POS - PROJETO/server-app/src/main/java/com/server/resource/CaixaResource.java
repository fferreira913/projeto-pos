package com.server.resource;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class CaixaResource extends ServerResource {

    @Post
    public Representation salvarComanda(Representation representation) throws IOException, JSONException{
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        return new StringRepresentation("ff");
    }
}