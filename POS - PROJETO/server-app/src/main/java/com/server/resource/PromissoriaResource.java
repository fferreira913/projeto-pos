package com.server.resource;

import com.br.util.Util;
import com.business.core.app.Promissoria;
import com.business.negocio.DaoTitulo;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
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
public class PromissoriaResource extends ServerResource{
    
    @Post
    public Representation salvarPromissoria(Representation representation) throws IOException, ParseException{
        JsonRepresentation jsonRepresentation = new JsonRepresentation(representation);
        JSONObject jSONObject = jsonRepresentation.getJsonObject();
        
        Promissoria promissoria = new Promissoria();
        promissoria.setNumero(jSONObject.getString("numero"));
        promissoria.setDescricao(jSONObject.getString("descricao"));
        promissoria.setFornecedor(jSONObject.getString("fornecedor"));
        promissoria.setDataEmissao(new Date());
        promissoria.setDataPagamento(new Date());
        promissoria.setStatus(Util.verificaStatus(jSONObject.getString("status")));
        
        DaoTitulo daoTitulo = new DaoTitulo();
        
        if(daoTitulo.salvarPromissoria(promissoria)){
            return new StringRepresentation("Salvo com sucesso!");
        }else{
            return new StringRepresentation("Erro!");
        }    
    }    
}
