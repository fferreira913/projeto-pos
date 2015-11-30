package com.server.resource;

import com.business.negocio.DaoTitulo;
import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TitulosFornecedorResource extends ServerResource {

    @Get
    public Representation listarTitulosPorFornecedor() {
        DaoTitulo daoTitulo = new DaoTitulo();
        String fornecedor = (String) getRequestAttributes().get("fornecedor");
        
        JSONArray jsArray = new JSONArray(daoTitulo.listarTitulosPorFornecedor(fornecedor));

        return new JsonRepresentation(jsArray);
    }
}
