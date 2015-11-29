package com.server.resource;

import com.business.negocio.DaoTitulo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TitulosResource extends ServerResource {
    
    @Get
    public Representation listarTitulosPorFornecedor() {
        DaoTitulo daoTitulo = new DaoTitulo();
        
        String fornecedor = (String) getRequestAttributes().get("fornecedor");
        
        //JSONArray array = new JSONArray(daoTitulo.listarTitulosPorFornecedor("Hora_10"));
        
        return new JsonRepresentation(daoTitulo.listarTitulosPorFornecedor(fornecedor).toString());
    }
}
