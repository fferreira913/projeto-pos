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
        //abrirPedido();
        //adicionarProduto();
        gerenciadorEntrega();
        //fecharComanda();
    }
    
    /*Abre um novo pedido vazio*/
    public static void abrirPedido() throws IOException {
        Pedido pedido = new Pedido();
        pedido.setComanda(8888);

        JSONObject jsono = new JSONObject();
        jsono.put("comanda", pedido.getComanda());

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }

    /*Adiciona um item ao pedido da comanda*/
    public static void adicionarProduto() throws IOException {
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1004");
        jsono.put("quantidade", 5);
        jsono.put("entregue", false);
        jsono.put("pedido", 33);

        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda/8888");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());

    }
    
    /*Entrega os pedidos e atualiza o caixa*/
    public static void gerenciadorEntrega() throws IOException{
        JSONObject jsono = new JSONObject();
        jsono.put("produto", "1004");
        jsono.put("quantidade", 5);
        jsono.put("pedido", 34);
        jsono.put("tipo", "salgado");
        
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/entrega");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
    
    /*Fecha a comanda*/
    public static void fecharComanda() throws IOException{
        ClientResource clientResource = new ClientResource("http://localhost:80/negocio/comanda/1111");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.delete();

        System.out.println("Resposta: " + rr.getText());

    }
}
