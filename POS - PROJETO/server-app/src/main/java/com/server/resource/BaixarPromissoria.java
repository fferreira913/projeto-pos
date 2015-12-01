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

public class BaixarPromissoria extends ServerResource{
    
    @Put
    public Representation baixarTitulo(Representation representation) throws IOException, JSONException{
        
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jsono = jsonRepresentation.getJsonObject();
        
        Promissoria promissoria = new Promissoria();
        promissoria.setDataEmissao(jsono.getString("dataEmissao"));
        promissoria.setDataPagamento(jsono.getString("dataPagamento"));
        promissoria.setDescricao(jsono.getString("descricao"));
        promissoria.setFornecedor(jsono.getString("fornecedor"));
        promissoria.setNumero(jsono.getString("numero"));
        promissoria.setStatus(Operacoes.verificaStatus(jsono.getString("status")));
        
        DaoContasPagar contasPagar = new DaoContasPagar();
        
        if(contasPagar.atualizarPromissoria(promissoria)){
            return new StringRepresentation("Pago com sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }
    }
}
