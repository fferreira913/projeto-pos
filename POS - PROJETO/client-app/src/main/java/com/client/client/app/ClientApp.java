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
public class ClientApp {

    public static void main(String[] args) throws IOException {
        atualizarProduto();
        //salvarProduto();
        //salvarPedido();
        //salvarComanda();
    }

    public static void salvarProduto() throws IOException {
        /*Salvar Produto*/
        Produto produto = new Produto();
        produto.setCodigo(1000);
        produto.setPreco(8.00);
        produto.setQuantidade(1000);
        produto.setTipo("Refrigerante");

        JSONObject jSONObject = new JSONObject();
        jSONObject.put("codigo", produto.getCodigo());
        jSONObject.put("preco", produto.getPreco());
        jSONObject.put("quantidade", produto.getQuantidade());
        jSONObject.put("tipo", produto.getTipo());

        ClientResource clientResource = new ClientResource("http://localhost:80/app/produto");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jSONObject);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }

    public static void atualizarProduto() throws IOException {
        /*Salvar Produto*/
        Produto produto = new Produto();
        produto.setCodigo(1000);
        produto.setPreco(8.00);
        produto.setQuantidade(1200);
        produto.setTipo("Refrigerante");

        JSONObject jSONObject = new JSONObject();
        jSONObject.put("codigo", produto.getCodigo());
        jSONObject.put("preco", produto.getPreco());
        jSONObject.put("quantidade", produto.getQuantidade());
        jSONObject.put("tipo", produto.getTipo());

        ClientResource clientResource = new ClientResource("http://localhost:80/app/produto");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jSONObject);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void salvarPedido() throws IOException{
        Pedido pedido = new Pedido();
        pedido.setCodigo(1111);
        pedido.setCliente("Fatinha");
        pedido.setEntregue(false);
        
        Produto produto1 = new Produto(1000, "Refrigerante", 8, 2);
        Produto produto2 = new Produto(1001, "Salgado", 6, 10);
        Produto produto3 = new Produto(1002, "Pizza 2 Sabores", 32, 2);
        
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
    
    public static void salvarComanda() throws IOException{
        Pedido pedido = new Pedido();
        pedido.setCodigo(1111);
        pedido.setCliente("Fatinha");
        pedido.setEntregue(false);
        
        Produto produto1 = new Produto(1000, "Refrigerante", 8, 2);
        Produto produto2 = new Produto(1001, "Salgado", 6, 10);
        Produto produto3 = new Produto(1002, "Pizza 2 Sabores", 32, 2);
        
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
}
