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
public class ComandaResource extends ServerResource{
    
    private static JSONObject jSONObject = null;
    
    @Post
    public Representation abrirComanda(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        
        jSONObject = jsonRepresentation.getJsonObject();
        
        return new StringRepresentation("Dados recebidos com sucesso");
    }
}
