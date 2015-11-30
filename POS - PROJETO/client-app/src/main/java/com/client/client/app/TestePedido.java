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
public class TestePedido {
    
    public static void main(String [] args) throws IOException{
        //salvarPedido();
        entregarPedido();
    }
    
    /*Testes Positivos*/
    public static void salvarPedido() throws IOException{
        Pedido pedido = new Pedido();
        pedido.setCodigo(1111);
        pedido.setCliente("Fatinha");
        pedido.setEntregue(false);
        
        Produto produto1 = new Produto(1000, "Salgado", 6, 2);
        Produto produto2 = new Produto(1001, "Refrigerante", 8, 10);
        Produto produto3 = new Produto(1003, "Pizza 2 Sabores", 32, 2);
        
        pedido.getProdutos().add(produto1);
        pedido.getProdutos().add(produto2);
        pedido.getProdutos().add(produto3);
        
        JSONObject jsono = new JSONObject();
        jsono.put("codigo", pedido.getCodigo());
        jsono.put("cliente", pedido.getCliente());
        jsono.put("entregue", pedido.isEntregue());
        jsono.put("produtos", pedido.getProdutos());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/pedido");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void entregarPedido() throws IOException{
        Pedido pedido = new Pedido(1111, "Fatinha", true);
        
        Produto produto1 = new Produto(1000, "Salgado", 6, 2);
        Produto produto2 = new Produto(1001, "Refrigerante", 8, 10);
        Produto produto3 = new Produto(1003, "Pizza 2 Sabores", 32, 2);
        
        pedido.getProdutos().add(produto1);
        pedido.getProdutos().add(produto2);
        pedido.getProdutos().add(produto3);
        
        JSONObject jsono = new JSONObject();
        jsono.put("codigo", pedido.getCodigo());
        jsono.put("cliente", pedido.getCliente());
        jsono.put("entregue", pedido.isEntregue());
        jsono.put("produtos", pedido.getProdutos());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/pedido");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
