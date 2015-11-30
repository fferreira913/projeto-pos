package com.business.core.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Fatinha de Sousa
 */

@Entity
public class Caixa implements Serializable{
    
    @Id
    private int codigo;
    private double valorTotal;
    
    public Caixa(){
        
    }

    public Caixa(int codigo, double valorTotal) {
        this.codigo = codigo;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Caixa{" + "codigo=" + codigo + ", valorTotal=" + valorTotal + '}';
    }
}
