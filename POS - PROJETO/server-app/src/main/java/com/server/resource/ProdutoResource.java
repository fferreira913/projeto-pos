package com.server.resource;

import com.business.core.app.Produto;
import com.business.negocio.DaoProduto;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class ProdutoResource extends ServerResource {

    @Post
    public Representation salvarProduto(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonR = new JsonRepresentation(representation);
        JSONObject json = jsonR.getJsonObject();

        Produto produto = new Produto();
        produto.setCodigo(json.getInt("codigo"));
        produto.setPreco(json.getDouble("preco"));
        produto.setQuantidade(json.getInt("quantidade"));
        produto.setTipo(json.getString("tipo"));

        DaoProduto daoProduto = new DaoProduto();
        boolean resposta = daoProduto.salvarProduto(produto);

        if (resposta == true) {
            return new StringRepresentation("Salvo Com Sucesso");
        } else {
            return new StringRepresentation("Erro!");
        }
    }

    @Put
    public Representation atualizarEstoque(Representation representation) throws IOException, JSONException {
        DaoProduto daoProduto = new DaoProduto();
        JsonRepresentation jsonR = new JsonRepresentation(representation);
        JSONObject json = jsonR.getJsonObject();

        Produto produto = daoProduto.buscarProduto(json.getInt("produto"));
        int qtdProduto = json.getInt("quantidade");

        if (produto.getQuantidade() > qtdProduto) {
            produto.setQuantidade(produto.getQuantidade() - qtdProduto);
            daoProduto.atualizarEstoque(produto);
            return new StringRepresentation("true");
        } else {
            return new StringRepresentation("false");
        }
    }
}
