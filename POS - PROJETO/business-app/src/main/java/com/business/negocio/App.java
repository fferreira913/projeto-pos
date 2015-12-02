package com.business.negocio;

import com.business.core.app.Caixa;

/**
 *
 * @author Fatinha de Sousa
 */
public class App {

    public static void main(String[] args) {
        Caixa caixa = new Caixa(1, 0);
        
        DaoCaixa daoCaixa = new DaoCaixa();
        
        daoCaixa.salvarCaixa(caixa);
    }
}
