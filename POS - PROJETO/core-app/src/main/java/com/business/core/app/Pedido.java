package com.business.core.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Fatinha de Sousa
 */

@Entity
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private int comanda;
    private boolean entregue;
    @ManyToOne
    private Produto produto;
    private int quantidade;
    
    public Pedido(){
        
    }

    public Pedido(int codigo, int comanda, boolean entregue, Produto produto, int quantidade) {
        this.codigo = codigo;
        this.comanda = comanda;
        this.entregue = entregue;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getComanda() {
        return comanda;
    }

    public void setComanda(int comanda) {
        this.comanda = comanda;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", comanda=" + comanda + ", entregue=" + entregue + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }
}
