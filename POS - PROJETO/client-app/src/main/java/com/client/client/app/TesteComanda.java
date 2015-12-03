package com.client.client.app;

import com.business.core.app.Pedido;
import com.business.core.app.Produto;
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

    public static void main(String[] args) throws IOException {
        //adicionarPedido();
        //abrirComanda();
        gerenciador();
    }

    public static void abrirComanda() throws IOException {
        Pedido pedido = new Pedido();
        pedido.setComanda(1111);

        JSONObject jsono = new JSONObject();
        jsono.put("comanda", pedido.getComanda());

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }

    public static void adicionarPedido() throws IOException {
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1003");
        jsono.put("quantidade", 10);

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda/1111");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }
    
    public static void gerenciador() throws IOException{
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1004");
        jsono.put("quantidade", 10);
        jsono.put("pedido", 13);
        
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/entrega");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
