package com.br.server;

import com.server.resource.BaixarDuplicada;
import com.server.resource.BaixarPromissoria;
import com.server.resource.CaixaResource;
import com.server.resource.ComandaResource;
import com.server.resource.DuplicadaResource;
import com.server.resource.PedidoResource;
import com.server.resource.ProdutoResource;
import com.server.resource.PromissoriaResource;
import com.server.resource.TituloStatusResource;
import com.server.resource.TitulosFornecedorResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.routing.Router;

/**
 *
 * @author Fatinha de Sousa
 */
public class ServerApp {

    public static void main(String[] args) throws Exception {
        
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 80);
        component.getClients().add(Protocol.HTTP);
        
        Application negocio = new Application();
        Router routerNegocio = new Router();
        routerNegocio.attach("/comanda", ComandaResource.class);
        negocio.setInboundRoot(routerNegocio);
        component.getDefaultHost().attach("/negocio", negocio);
        
        Application basico = new Application();
        Router routerBasico = new Router();
        routerBasico.attach("/pedido", PedidoResource.class);
        basico.setInboundRoot(routerBasico);
        component.getDefaultHost().attach("/basico", basico);
        component.start();
    }
    
}