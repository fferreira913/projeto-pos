package com.server.resource;

import com.br.util.Operacoes;
import com.business.core.app.Duplicada;
import com.business.negocio.DaoContasPagar;
import java.io.IOException;
import java.util.Date;
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

public class DuplicadaResource extends ServerResource{
    
    @Post
    public Representation salvarDuplicada(Representation representation) throws IOException, JSONException{
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jSONObject = jsonRepresentation.getJsonObject();
        
        Duplicada duplicada = new Duplicada();
        duplicada.setNumero(jSONObject.getString("numero"));
        duplicada.setBanco(Operacoes.verificarBanco(jSONObject.getString("banco")));
        duplicada.setDataEmissao(jSONObject.getString("dataEmissao"));
        duplicada.setDataPagamento(jSONObject.getString("dataPagamento"));
        duplicada.setDescricao(jSONObject.getString("descricao"));
        duplicada.setFornecedor(jSONObject.getString("fornecedor"));
        duplicada.setStatus(Operacoes.verificaStatus(jSONObject.getString("status")));
        
        DaoContasPagar daoTitulo = new DaoContasPagar();
        if(daoTitulo.salvarDuplicada(duplicada)){
            return new StringRepresentation("Duplicada salva com sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }
    }
}
