package com.server.resource;

import com.business.negocio.DaoPedido;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class GerenciadorPagamento extends ServerResource {

    @Put
    public Representation fecharComanda(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        ClientResource clientResource = new ClientResource("http://localhost:80/basico/caixa");
        JsonRepresentation jr = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jr);

        if (rr.getText().equalsIgnoreCase("true")) {
            ClientResource cr = new ClientResource("http://localhost:80/basico/pedido/" + jsono.getInt("comanda"));
            ReadableRepresentation r = (ReadableRepresentation) cr.delete();
            return new StringRepresentation(r.getText());
        } else {
            return new StringRepresentation("Saldo Insuficiente");
        }
    }
}
