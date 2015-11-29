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
public class Produto implements Serializable{
    
    @Id
    private int codigo;
    private String tipo;
    private double preco;
    private int quantidade;
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;
    
    public Produto(){
        
    }

    public Produto(int codigo, String tipo, double preco, int quantidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.pedidos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipoProduto) {
        this.tipo = tipoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", tipoProduto=" + tipo + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
}
