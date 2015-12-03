package com.business.negocio;

import com.business.core.app.Caixa;
import com.business.core.app.Pedido;
import java.util.List;

/**
 *
 * @author Fatinha de Sousa
 */
public class App {

    public static void main(String[] args) {
        DaoPedido daoPedido = new DaoPedido();
        DaoCaixa daoCaixa = new DaoCaixa();

        Caixa caixa = new Caixa();
        caixa.setCodigo(1);
        caixa.setValorTotal(caixa.getValorTotal() + 250);
        daoCaixa.atualizarCaixa(caixa);
        /*
        double total = daoPedido.totalComanda(1111);

        Caixa caixa = new Caixa();
        caixa.setCodigo(1);
        caixa.setValorTotal(caixa.getValorTotal() + total);

        daoCaixa.atualizarCaixa(caixa);*/
    }
}
