package com.server.resource;

import com.business.core.app.Comanda;
import com.business.core.app.Pedido;
import com.business.negocio.DaoComanda;
import java.io.IOException;
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
public class ComandaResource extends ServerResource {

    @Post
    public Representation salvarComanda(Representation representation) throws IOException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        Comanda comanda = new Comanda();
        comanda.setCodigo(jsono.getInt("codigo"));
        comanda.setPago(jsono.getBoolean("pago"));
        comanda.setTotal(jsono.getDouble("total"));

        DaoComanda daoComanda = new DaoComanda();
        
        if(daoComanda.salvarComanda(comanda)){
            return new StringRepresentation("Salvo Com Sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }
    }

    @Put
    public Representation atualizarComanda(Representation representation) throws IOException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        Comanda comanda = new Comanda();
        comanda.setCodigo(jsono.getInt("codigo"));
        comanda.setPago(jsono.getBoolean("pago"));
        comanda.setTotal(jsono.getDouble("total"));
        
        //comanda.setPedido(jsono.getJSONObject("codigo"));
        
        DaoComanda daoComanda = new DaoComanda();
        
        if(daoComanda.salvarComanda(comanda)){
            return new StringRepresentation("Salvo Com Sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }
    }
}
