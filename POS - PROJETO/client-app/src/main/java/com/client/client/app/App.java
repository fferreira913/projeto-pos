package com.client.client.app;

import com.br.util.Util;
import com.business.core.app.Banco;
import com.business.core.app.Duplicada;
import com.business.core.app.Promissoria;
import com.business.core.app.Status;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class App {

    public static void main(String[] args) throws IOException, ParseException {
        //salvarPromissoria();
        salvarDuplicada();
    }

    public static void salvarDuplicada() throws IOException {
        Duplicada duplicada = new Duplicada();
        duplicada.setBanco(Banco.CEF);
        duplicada.setDataEmissao(new Date());
        duplicada.setDataPagamento(new Date());
        duplicada.setDescricao("Duplicada 01");
        duplicada.setFornecedor("Hora 10 Conveniencia");
        duplicada.setNumero("8999-006");
        duplicada.setStatus(Status.PAGO);

        JSONObject jSONObject = new JSONObject();
        jSONObject.put("banco", duplicada.getBanco());
        jSONObject.put("dataEmissao", duplicada.getDataEmissao());
        jSONObject.put("dataPagamento", duplicada.getDataPagamento());
        jSONObject.put("descricao", duplicada.getDescricao());
        jSONObject.put("fornecedor", duplicada.getFornecedor());
        jSONObject.put("numero", duplicada.getNumero());
        jSONObject.put("status", duplicada.getStatus());

        ClientResource clientResource = new ClientResource("http://localhost:80/app/duplicada");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jSONObject);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }

    public static void salvarPromissoria() throws IOException, ParseException {
        Promissoria promissoria = new Promissoria();
        promissoria.setNumero("8999-003");
        promissoria.setFornecedor("Hora 10");
        promissoria.setDescricao("Promissoria 01");
        promissoria.setDataEmissao(Util.parseStringDate("29/11/2015"));
        promissoria.setDataPagamento(Util.parseStringDate("29/11/2015"));
        promissoria.setStatus(Status.PAGO);

        JSONObject jSONObject = new JSONObject();
        jSONObject.put("numero", promissoria.getNumero());
        jSONObject.put("fornecedor", promissoria.getFornecedor());
        jSONObject.put("descricao", promissoria.getDescricao());
        jSONObject.put("dataEmissao", promissoria.getDataEmissao());
        jSONObject.put("dataPagamento", promissoria.getDataPagamento());
        jSONObject.put("status", promissoria.getStatus());

        ClientResource clientResource = new ClientResource("http://localhost:80/app/promissoria");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jSONObject);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
