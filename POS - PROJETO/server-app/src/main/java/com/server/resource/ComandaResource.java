package com.server.resource;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class ComandaResource extends ServerResource {

    @Post
    public Representation abrirComanda(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);

        ClientResource clientResource = new ClientResource("http://localhost:80/basico/pedido");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        return new StringRepresentation(rr.getText());
    }

    @Put
    public Representation adicionarPedido(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        String codigoComanda = (String) getRequestAttributes().get("codigoComanda");
        int codigo = Integer.parseInt(codigoComanda);
        
        jsono.put("comanda", codigo);
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/pedido");
        JsonRepresentation representation1 = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(representation1);
        return new StringRepresentation(rr.getText());
        
    }
}