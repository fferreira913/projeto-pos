package com.client.client.app;

import com.business.core.app.Comanda;
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
    
    public static void main(String [] args){
        
    }
    
    /*Teste Positivo*/
    public static void abrirComanda() throws IOException{
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
        
        double total = 0;
        
        for (Produto p : pedido.getProdutos()) {
            total += p.getPreco() * p.getQuantidade();
        }
        
        Comanda comanda = new Comanda();
        comanda.setCodigo(1221);
        comanda.setPago(false);
        comanda.setTotal(total);
        comanda.setPedido(pedido);
        
        JSONObject jsono = new JSONObject();
        jsono.put("codigo", comanda.getCodigo());
        jsono.put("pago", comanda.isPago());
        jsono.put("total", comanda.getTotal());
        jsono.put("pedido", comanda.getPedido());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/caixa");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
        
    }
    
    public static void fecharComanda(){
        
    }
}
