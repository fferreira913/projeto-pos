package com.br.util;

import com.business.core.app.Banco;
import com.business.core.app.Status;

/**
 *
 * @author Fatinha de Sousa
 */
public class Operacoes {

    public static Status verificaStatus(String status) {

        if (status.equalsIgnoreCase("PAGO")) {
            return Status.PAGO;
        } else if (status.equalsIgnoreCase("VENCIDO")) {
            return Status.VENCIDO;
        } else if (status.equalsIgnoreCase("A_VENCER")) {
            return Status.A_VENCER;
        } else {
            return null;
        }
    }

    public static Banco verificarBanco(String banco) {
        if (banco.equalsIgnoreCase("BB")) {
            return Banco.BB;
        } else if (banco.equalsIgnoreCase("BRADESCO")) {
            return Banco.BRADESCO;
        } else if (banco.equalsIgnoreCase("CEF")) {
            return Banco.CEF;
        }else{
            return null;
        }
    }
}
