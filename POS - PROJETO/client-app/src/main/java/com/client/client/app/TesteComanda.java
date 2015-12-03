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

    public static void main(String[] args) throws IOException {
        //adicionarPedido();
        //abrirComanda();
        gerenciador();
        //fecharComanda();
    }
    
    public static void fecharComanda() throws IOException{
        JSONObject jsono = new JSONObject();
        jsono.put("comanda", 2222);
        
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }

    public static void abrirComanda() throws IOException {
        Pedido pedido = new Pedido();
        pedido.setComanda(2222);

        JSONObject jsono = new JSONObject();
        jsono.put("comanda", pedido.getComanda());

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }

    public static void adicionarPedido() throws IOException {
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1004");
        jsono.put("quantidade", 5);
        jsono.put("entregue", false);
        jsono.put("pedido", 18);

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda/1111");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }
    
    public static void gerenciador() throws IOException{
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1004");
        jsono.put("quantidade", 5);
        jsono.put("pedido", 18);
        jsono.put("tipo", "salgado");
        
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/entrega");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
