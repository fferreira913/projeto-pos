package com.server.resource;

import com.br.util.Operacoes;
import com.business.core.app.Duplicada;
import com.business.negocio.DaoContasPagar;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StreamRepresentation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class BaixarDuplicada extends ServerResource {
    
    @Put
    public Representation pagarDuplicada(Representation representation) throws IOException, JSONException {
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        Duplicada duplicada = new Duplicada();
        duplicada.setBanco(Operacoes.verificarBanco(jsono.getString("banco")));
        duplicada.setDataEmissao(jsono.getString("dataEmissao"));
        duplicada.setDataPagamento(jsono.getString("dataPagamento"));
        duplicada.setDescricao(jsono.getString("descricao"));
        duplicada.setFornecedor(jsono.getString("fornecedor"));
        duplicada.setNumero(jsono.getString("numero"));
        duplicada.setStatus(Operacoes.verificaStatus(jsono.getString("status")));
        
        DaoContasPagar daoTitulo = new DaoContasPagar();
        
        if(daoTitulo.atualizarDuplicada(duplicada)){
            return new StringRepresentation("Atualizado Com Sucesso");
        }else{
            return new StringRepresentation("Erro");
        }
    }
}
