package com.business.core.app;

import java.io.Serializable;

/**
 *
 * @author Fatinha de Sousa
 */

public class Comanda implements Serializable{
    
    private int codigo;
    private Pedido pedido;
    private double total;
    private boolean pago;
    
    public Comanda(){
        
    }

    public Comanda(int codigo, Pedido pedido, double total, boolean pago) {
        this.codigo = codigo;
        this.pedido = pedido;
        this.total = total;
        this.pago = pago;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Comanda{" + "Codigo=" + codigo + ", pedido=" + pedido + ", total=" + total + ", pago=" + pago + '}';
    }
}
