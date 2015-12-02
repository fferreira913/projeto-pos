package com.br.server;

import com.server.resource.ComandaResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Fatinha de Sousa
 */
public class ServerComanda {

    public static void main(String[] args) throws Exception {

        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 80);
        Router router = new Router();
        router.attach("/comanda", ComandaResource.class);

        Application app = new Application();
        app.setInboundRoot(router);
        component.getDefaultHost().attach("/app", app);

        component.start();

    }

}
