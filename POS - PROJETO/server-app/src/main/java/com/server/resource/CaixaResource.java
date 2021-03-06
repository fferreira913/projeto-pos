package com.server.resource;

import com.business.core.app.Caixa;
import com.business.negocio.DaoCaixa;
import com.business.negocio.DaoPedido;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class CaixaResource extends ServerResource {

    @Put
    public Representation atualizarCaixa(Representation representation) throws IOException, JSONException {
        DaoCaixa daoCaixa = new DaoCaixa();
        DaoPedido daoPedido = new DaoPedido();

        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        double total = daoPedido.totalComanda(jsono.getInt("comanda"));

        Caixa caixa = daoCaixa.getCaixa(1);
        caixa.setValorTotal(caixa.getValorTotal() + total);

        if (daoCaixa.atualizarCaixa(caixa)) {
            return new StringRepresentation("true");
        } else {
            return new StringRepresentation("false");
        }
    }
}
