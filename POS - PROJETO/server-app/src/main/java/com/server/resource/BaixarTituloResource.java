package com.server.resource;

import com.br.util.Operacoes;
import com.business.core.app.Promissoria;
import com.business.core.app.Titulo;
import com.business.negocio.DaoContasPagar;
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
public class BaixarTituloResource extends ServerResource {

    @Put
    public Representation pagarTitulo(Representation representation) throws IOException, JSONException {
        DaoContasPagar daoTitulo = new DaoContasPagar();

        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();

        Titulo titulo = daoTitulo.buscarTitulo(jsono.getString("numero"));
        titulo.setStatus(Operacoes.verificaStatus(jsono.getString("status")));
        if (daoTitulo.atualizarTitulo(titulo)) {
            return new StringRepresentation("Baixar Titulo OK");
        } else {
            return new StringRepresentation("Erro");
        }
    }
}
