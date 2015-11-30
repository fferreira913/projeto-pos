package com.server.resource;

import com.business.core.app.Caixa;
import com.business.core.app.Comanda;
import com.business.core.app.Pedido;
import com.business.negocio.DaoCaixa;
import java.io.IOException;
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
public class CaixaResource extends ServerResource {

    @Post
    public Representation atualizarCaixa(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        Comanda comanda = new Comanda();
        comanda.setCodigo(jsono.getInt("codigo"));
        comanda.setPago(jsono.getBoolean("pago"));
        comanda.setTotal(jsono.getDouble("total"));
        
        JSONArray pedidos = jsono.getJSONArray("pedido");
        JSONObject jSONObject = pedidos.getJSONObject(0);
        Pedido pedido = new Pedido();
        pedido.setCodigo(jSONObject.getInt("codigo"));
        pedido.setCliente(jSONObject.getString("cliente"));
        pedido.setEntregue(jSONObject.getBoolean("entregue"));
        
        comanda.setPedido(pedido);
        
        Caixa caixa = new Caixa();
        caixa.setValorTotal(comanda.getTotal());
        
        DaoCaixa daoComanda = new DaoCaixa();
        
        if(daoComanda.atualizarCaixa(caixa)){
            return new StringRepresentation("Atualizado Com Sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }
    }
}