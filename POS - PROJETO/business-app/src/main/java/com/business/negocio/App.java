package com.business.negocio;

import com.business.core.app.Status;
import com.business.core.app.Titulo;
import java.util.List;

/**
 *
 * @author Fatinha de Sousa
 */
public class App {

    public static void main(String[] args) {
        DaoContasPagar daoTitulo = new DaoContasPagar();
        
        List<Titulo> titulos = daoTitulo.listarTitulosPorFornecedor("Hora 10");
        
        for (Titulo titulo : titulos) {
            System.out.println("Titulo: " +titulo.getDescricao());
        }
        
        List<Titulo> titulos1 = daoTitulo.listarTitulosPorStatus(Status.VENCIDO);
        
        for (Titulo titulo : titulos1) {
            System.out.println("Titulo: " +titulo.getDescricao());
        }
    }
}
