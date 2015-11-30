package com.server.resource;

import com.business.core.app.Pedido;
import com.business.core.app.Produto;
import com.business.negocio.DaoPedido;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class PedidoResource extends ServerResource {

    @Post
    public Representation salvarPedido(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        Pedido pedido = new Pedido();
        pedido.setCodigo(jsono.getInt("codigo"));
        pedido.setCliente(jsono.getString("cliente"));
        pedido.setEntregue(jsono.getBoolean("entregue"));
        
        JSONArray produtos = jsono.getJSONArray("produtos");

        for (int i = 0; i < produtos.length(); i++) {
            JSONObject nObject = produtos.getJSONObject(i);
            Produto produto = new Produto();
            
            produto.setCodigo(nObject.getInt("codigo"));
            produto.setPreco(nObject.getDouble("preco"));
            produto.setQuantidade(nObject.getInt("quantidade"));
            produto.setTipo(nObject.getString("tipo"));
            
            pedido.getProdutos().add(produto);
        }

        DaoPedido daoPedido = new DaoPedido();

        if (daoPedido.salvarPedido(pedido)) {
            return new StringRepresentation("Salvo Com Sucesso");
        } else {
            return new StringRepresentation("Erro!");
        }
    }
}
