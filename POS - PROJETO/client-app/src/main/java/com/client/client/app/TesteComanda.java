package com.client.client.app;

import com.business.core.app.Pedido;
import java.io.IOException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TesteComanda {
    
    public static void main(String [] args) throws IOException{
        
        abrirComanda();
    }
    
    public static void abrirComanda() throws IOException{
        Pedido pedido = new Pedido();
        pedido.setComanda(1003);
        
        JSONObject jsono = new JSONObject();
        jsono.put("comanda", pedido.getComanda());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
        
    }
}