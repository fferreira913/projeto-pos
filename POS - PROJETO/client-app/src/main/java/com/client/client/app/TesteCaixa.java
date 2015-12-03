package com.client.client.app;

import java.io.IOException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TesteCaixa {

    public static void main(String[] args) throws IOException {
        atualizarCaixa();
    }

    public static void atualizarCaixa() throws IOException {
        JSONObject jsono = new JSONObject();
        jsono.put("comanda", 1111);

        ClientResource clientResource = new ClientResource("http://localhost:80/basico/caixa");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
