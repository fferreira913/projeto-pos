package com.business.core.app;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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
    @OneToOne(mappedBy = "pedido")
    private Comanda comanda;
    
    public Pedido(){
    
    }

    public Pedido(int codigo, String cliente, boolean entregue, List<Produto> produtos, Comanda comanda) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.entregue = entregue;
        this.produtos = produtos;
        this.comanda = comanda;
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

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", entregue=" + entregue + '}';
    }
}
