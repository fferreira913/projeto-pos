package com.business.core.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    
    public Produto(){
        
    }

    public Produto(int codigo, String tipo, double preco, int quantidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
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

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", tipo=" + tipo + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
    
}
