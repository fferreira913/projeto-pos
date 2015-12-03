package com.server.resource;

import com.business.core.app.Pedido;
import com.business.core.app.Produto;
import com.business.negocio.DaoPedido;
import com.business.negocio.DaoProduto;
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
public class GerenciadorResource extends ServerResource {

    @Put
    public Representation atualizarDados(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject json = jsonRepresentation.getJsonObject();
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/produto");
        JsonRepresentation jr = new JsonRepresentation(json);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jr);

        if (rr.getText().equalsIgnoreCase("true")) {
            
            json.put("entregue", true);
            
            ClientResource clientPedido = new ClientResource("http://localhost:80/basico/pedido");
            JsonRepresentation jr2 = new JsonRepresentation(json);
            ReadableRepresentation readableRepresentation = (ReadableRepresentation) clientPedido.put(jr2);
            return new StringRepresentation(readableRepresentation.getText());
        
        } else {
            return new StringRepresentation("Estoque insuficiente");
        }

    }

}
