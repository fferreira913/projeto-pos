package com.server.resource;

import com.br.util.Operacoes;
import com.business.negocio.DaoContasPagar;
import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TituloStatusResource extends ServerResource{
    
    @Get
    public Representation listarTitulosPorStatus(){
        
        String status = (String) getRequestAttributes().get("status");
        
        DaoContasPagar daoTitulo = new DaoContasPagar();
        
        JSONArray array = new JSONArray(daoTitulo.listarTitulosPorStatus(Operacoes.verificaStatus(status)));
        
        return new JsonRepresentation(array);
        
    }
}
