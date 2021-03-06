package com.client.client.app;

import com.business.core.app.Banco;
import com.business.core.app.Duplicada;
import com.business.core.app.Promissoria;
import com.business.core.app.Status;
import com.business.core.app.Titulo;
import java.io.IOException;
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
        //listarTitulosPorStatus();
        pagarTitulo();
        
    }
    
    /*Teste Positivo*/
    public static void salvarPromissoria() throws IOException{
        
        Promissoria promissoria = new Promissoria();
        
        promissoria.setDataEmissao("01/12/2015");
        promissoria.setDataPagamento("13/12/2015");
        promissoria.setDescricao("Promissoria 03");
        promissoria.setFornecedor("BRASIL");
        promissoria.setNumero("333-333");
        promissoria.setStatus(Status.A_VENCER);
        
        JSONObject jsono = new JSONObject();
        jsono.put("dataEmissao", promissoria.getDataEmissao());
        jsono.put("dataPagamento", promissoria.getDataPagamento());
        jsono.put("descricao", promissoria.getDescricao());
        jsono.put("fornecedor", promissoria.getFornecedor());
        jsono.put("numero", promissoria.getNumero());
        jsono.put("status", promissoria.getStatus());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/promissoria");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
        
    }
    
    public static void salvarDuplicada() throws IOException{
        
        Duplicada duplicada = new Duplicada();
        duplicada.setBanco(Banco.BB);
        duplicada.setDataEmissao("01/12/2015");
        duplicada.setDataPagamento("13/12/2015");
        duplicada.setDescricao("Duplicada 03");
        duplicada.setFornecedor("Russia");
        duplicada.setNumero("333-334");
        duplicada.setStatus(Status.A_VENCER);
        
        JSONObject jsono = new JSONObject();
        jsono.put("dataEmissao", duplicada.getDataEmissao());
        jsono.put("dataPagamento", duplicada.getDataPagamento());
        jsono.put("descricao", duplicada.getDescricao());
        jsono.put("fornecedor", duplicada.getFornecedor());
        jsono.put("numero", duplicada.getNumero());
        jsono.put("status", duplicada.getStatus());
        jsono.put("banco", duplicada.getBanco());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/duplicada");
        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.post(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void listarTitulosPorFornecedor() throws IOException{
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/titulosFornecedor/Russia");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.get();

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void listarTitulosPorStatus() throws IOException{
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/titulosStatus/PAGO");
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.get();

        System.out.println("Resposta: " + rr.getText());
    }
    
    public static void pagarTitulo() throws IOException{
        Titulo titulo = new Titulo();
        titulo.setNumero("333-335");
        titulo.setStatus(Status.PAGO);
        
        JSONObject jsono = new JSONObject();
        jsono.put("numero", titulo.getNumero());
        jsono.put("status", titulo.getStatus());
        
        ClientResource clientResource = new ClientResource("http://localhost:80/basico/baixarTitulo");

        JsonRepresentation jsonRepresentation = new JsonRepresentation(jsono);
        ReadableRepresentation rr = (ReadableRepresentation) clientResource.put(jsonRepresentation);

        System.out.println("Resposta: " + rr.getText());
    }
}
