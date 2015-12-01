package com.business.core.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fatinha de Sousa
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Titulo implements Serializable{
    
    @Id
    private String numero;
    private String dataEmissao;
    private String dataPagamento;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String fornecedor;
 
    public Titulo(){
        
    }

    public Titulo(String numero, String dataEmissao, String dataPagamento, String descricao, Status status, String fornecedor) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataPagamento = dataPagamento;
        this.descricao = descricao;
        this.status = status;
        this.fornecedor = fornecedor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Titulo{" + "numero=" + numero + ", dataEmissao=" + dataEmissao + ", dataPagamento=" + dataPagamento + ", descricao=" + descricao + ", status=" + status + ", fornecedor=" + fornecedor + '}';
    }
}
