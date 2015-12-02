package com.br.util;

import java.io.IOException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class ResourceServices {
    
    public static Representation abrirComanda(JsonRepresentation jsonRepresentation) throws IOException{
        ClientResource clientResource = new ClientResource("http://localhost:80/app/caixa");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
        return rr;
        
    }
    
}
