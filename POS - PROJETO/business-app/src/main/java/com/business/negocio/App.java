package com.business.negocio;

import com.business.core.app.Duplicada;
import com.business.core.app.Promissoria;
import com.business.core.app.Status;
import com.business.core.app.Titulo;

/**
 *
 * @author Fatinha de Sousa
 */
public class App {

    public static void main(String[] args) {

        DaoContasPagar contasPagar = new DaoContasPagar();

        Titulo titulo = contasPagar.buscarTitulo("101-005");
        titulo.setStatus(Status.PAGO);
        contasPagar.atualizarTitulo(titulo);
        
        if (titulo instanceof Promissoria) {
            System.out.println("Promissoria");
        } else if (titulo instanceof Duplicada) {
            System.out.println("Duplicada");
        }
    }
}
