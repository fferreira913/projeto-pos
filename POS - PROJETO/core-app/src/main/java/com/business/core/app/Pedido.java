package com.business.core.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Fatinha de Sousa
 */

@Entity
public class Pedido implements Serializable{
    
    @Id
    private int codigo;
    private String cliente;
    private boolean entregue;
    @ManyToMany
    private List<Produto> produtos;
    
    public Pedido(){
        this.produtos = new ArrayList();
    }

    public Pedido(int codigo, String cliente, boolean entregue) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.entregue = entregue;
        this.produtos = new ArrayList();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", entregue=" + entregue + '}';
    }
}
