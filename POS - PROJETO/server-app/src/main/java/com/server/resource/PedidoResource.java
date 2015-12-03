package com.server.resource;

import com.business.core.app.Pedido;
import com.business.core.app.Produto;
import com.business.negocio.DaoPedido;
import com.business.negocio.DaoProduto;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
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
        pedido.setComanda(jsono.getInt("comanda"));
        
        DaoPedido daoPedido = new DaoPedido();

        if (daoPedido.salvarPedido(pedido)) {
            return new StringRepresentation("Salvo Com Sucesso");
        } else {
            return new StringRepresentation("Erro!");
        }
    }
    
    @Put
    public Representation atualizarPedido(Representation representation) throws IOException, JSONException{
        DaoPedido daoPedido = new DaoPedido();
        
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        Pedido pedido = daoPedido.buscarPedido(jsono.getInt("pedido"));
        
        if(pedido != null){
            pedido.setEntregue(jsono.getBoolean("entregue"));
            if(daoPedido.atualizarPedido(pedido)){
                return new StringRepresentation("Pedido Entregue Com Sucesso!");
            }else{
                return new StringRepresentation("Erro Desconhecido");
            }
            
        }else{
            return new StringRepresentation("Nenhum Pedido Encontrado!");
        }
    }
}
