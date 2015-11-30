package com.business.core.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Fatinha de Sousa
 */

@Entity
public class Duplicada extends Titulo implements Serializable{
    
    @Enumerated(EnumType.STRING)
    private Banco banco;
    
    public Duplicada(){
    }

    public Duplicada(Banco banco, String numero, Date dataEmissao, Date dataPagamento, String descricao, Status status, String fornecedor) {
        super(numero, dataEmissao, dataPagamento, descricao, status, fornecedor);
        this.banco = banco;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Duplicada{" + super.toString() + "banco=" + banco + '}';
    }
}
