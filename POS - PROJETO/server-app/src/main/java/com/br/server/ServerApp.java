package com.br.server;

import com.server.resource.CaixaResource;
import com.server.resource.ComandaResource;
import com.server.resource.EntregaResource;
import com.server.resource.GerenciadorResource;
import com.server.resource.PedidoResource;
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
        component.getClients().add(Protocol.HTTP);
        
        Application negocio = new Application();
        Router routerNegocio = new Router();
        routerNegocio.attach("/comanda", ComandaResource.class);
        routerNegocio.attach("/comanda/{codigoComanda}", ComandaResource.class);
        routerNegocio.attach("/entrega", EntregaResource.class);
        negocio.setInboundRoot(routerNegocio);
        component.getDefaultHost().attach("/negocio", negocio);
        
        Application basico = new Application();
        Router routerBasico = new Router();
        routerBasico.attach("/pedido", PedidoResource.class);
        routerBasico.attach("/produto", ProdutoResource.class);
        routerBasico.attach("/caixa", CaixaResource.class);
        basico.setInboundRoot(routerBasico);
        component.getDefaultHost().attach("/basico", basico);
        
        Application gerenciador = new Application();
        Router routerGerenciador = new Router();
        routerGerenciador.attach("/gerenciadorPedidos", GerenciadorResource.class);
        gerenciador.setInboundRoot(routerGerenciador);
        component.getDefaultHost().attach("/gerenciador", gerenciador);
        
        component.start();
    }
    
}