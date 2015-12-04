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
public class TesteProduto {

    public static void main(String [] args) throws IOException{
        
        salvarProduto();
    }
    
    /*Salvar Um Produto Qualquer, apenas testes simples de CRUD*/
    public static void salvarProduto() throws IOException {
        Produto produto = new Produto();
        produto.setCodigo(1008);
        produto.setPreco(6);
        produto.setQuantidade(1500);
        produto.setTipo("Salgado");

        JSONObject jSONObject = new JSONObject();
        jSONObject.put("codigo", produto.getCodigo());
        jSONObject.put("preco", produto.getPreco());
        jSONObject.put("quantidade", produto.getQuantidade());
        jSONObject.put("tipo", produto.getTipo());

        ClientResource clientResource = new ClientResource("http://localhost:80/basico/produto");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jSONObject);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
