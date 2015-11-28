package com.br.server;

import com.server.resource.ProdutoResource;
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
        
        Application app = new Application();
        app.setInboundRoot(router);
        component.getDefaultHost().attach("/app", app);
        
        component.start();
    }
    
}
