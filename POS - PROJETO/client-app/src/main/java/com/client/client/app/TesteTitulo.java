package com.client.client.app;

import com.business.core.app.Banco;
import com.business.core.app.Duplicada;
import com.business.core.app.Promissoria;
import com.business.core.app.Status;
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.ReadableRepresentation;
import org.restlet.resource.ClientResource;

/**
 *
 * @author Fatinha de Sousa
 */
public class TesteTitulo {

    public static void main(String [] args) throws IOException{
        //salvarPromissoria();
        //salvarDuplicada();
        //listarTitulosPorFornecedor();
        listarTitulosPorStatus();
    }
    
    /*Teste Positivo*/
    public static void salvarPromissoria() throws IOException{
        
        Promissoria promissoria = new Promissoria();
        
        promissoria.setDataEmissao(new Date());
        promissoria.setDataPagamento(new Date());
        promissoria.setDescricao("Promissoria 01");
        promissoria.setFornecedor("Brasil");
        promissoria.setNumero("101-003");
        promissoria.setStatus(Status.VENCIDO);
        
        JSONObject jsono = new JSONObject();
        jsono.put("dataEmissao", promissoria.getDataEmissao());
        jsono.put("dataPagamento", promissoria.getDataPagamento());
        jsono.put("descricao", promissoria.getDescricao());
        jsono.put("fornecedor", promissoria.getFornecedor());
        jsono.put("numero", promissoria.getNumero());
        jsono.put("status", promissoria.getStatus());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/promissoria");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
        
    }
    
    public static void salvarDuplicada() throws IOException{
        
        Duplicada duplicada = new Duplicada();
        duplicada.setBanco(Banco.CEF);
        duplicada.setDataEmissao(new Date());
        duplicada.setDataPagamento(new Date());
        duplicada.setDescricao("Duplicada 03");
        duplicada.setFornecedor("Russia");
        duplicada.setNumero("101-006");
        duplicada.setStatus(Status.VENCIDO);
        
        JSONObject jsono = new JSONObject();
        jsono.put("dataEmissao", duplicada.getDataEmissao());
        jsono.put("dataPagamento", duplicada.getDataPagamento());
        jsono.put("descricao", duplicada.getDescricao());
        jsono.put("fornecedor", duplicada.getFornecedor());
        jsono.put("numero", duplicada.getNumero());
        jsono.put("status", duplicada.getStatus());
        jsono.put("banco", duplicada.getBanco());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/duplicada");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void listarTitulosPorFornecedor() throws IOException{
        
        ClientResource clientResource = new ClientResource("http://localhost:80/app/titulos/Russia");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.get();

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void listarTitulosPorStatus() throws IOException{
        ClientResource clientResource = new ClientResource("http://localhost:80/app/titulos2/PAGO");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.get();

        System.out.println("Resposta: " + rr.getText());
    }
}
