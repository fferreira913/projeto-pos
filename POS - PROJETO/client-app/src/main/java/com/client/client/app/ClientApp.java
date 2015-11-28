package com.client.client.app;

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
    }

    public static void salvarProduto() throws IOException {
        /*Salvar Produto*/
        Produto produto = new Produto();
        produto.setCodigo(2000);
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
        produto.setQuantidade(500);
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

}
