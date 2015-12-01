package com.business.core.app;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Fatinha de Sousa
 */
@Entity
public class Promissoria extends Titulo implements Serializable{

    public Promissoria() {
    }

    public Promissoria(String numero, String dataEmissao, String dataPagamento, String descricao, Status status, String fornecedor) {
        super(numero, dataEmissao, dataPagamento, descricao, status, fornecedor);
    }

    @Override
    public String toString() {
        return "Promissoria{" +super.toString()+ '}';
    }
}
