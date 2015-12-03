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
    public Representation fecharComanda(Representation representation) throws IOException, JSONException{
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        DaoPedido daoPedido = new DaoPedido();
        double total = daoPedido.totalComanda(jsono.getInt("comanda"));
        
        jsono.put("total", total);
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/caixa");
        JsonRepresentation jr = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jr);
        
        if(rr.getText().equalsIgnoreCase("true")){
            daoPedido.deletarComanda(jsono.getInt("comanda"));
            return new StringRepresentation("Comanda Encerrada Com Sucesso");
        }else{
            return new StringRepresentation("Saldo Insuficiente");
        }
    }
}