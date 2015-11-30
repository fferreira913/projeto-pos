package com.br.server;

import com.server.resource.ComandaResource;
import com.server.resource.DuplicadaResource;
import com.server.resource.PedidoResource;
import com.server.resource.ProdutoResource;
import com.server.resource.PromissoriaResource;
import com.server.resource.TituloStatusResource;
import com.server.resource.TitulosResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Fatinha de Sousa
 */
public class ServerApp {

    public static void main(String[] args) throws Exception {
        
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 80);
        Router router = new Router();
        router.attach("/produto", ProdutoResource.class);
        router.attach("/pedido", PedidoResource.class);
        router.attach("/caixa", ComandaResource.class);
        router.attach("/promissoria", PromissoriaResource.class);
        router.attach("/duplicada", DuplicadaResource.class);
        router.attach("/titulos/{fornecedor}", TitulosResource.class);
        router.attach("/titulos2/{status}", TituloStatusResource.class);
        
        Application app = new Application();
        app.setInboundRoot(router);
        component.getDefaultHost().attach("/app", app);
        
        component.start();
    }
    
}
