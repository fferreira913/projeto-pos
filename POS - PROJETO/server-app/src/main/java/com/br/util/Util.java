package com.br.util;

import com.business.core.app.Banco;
import com.business.core.app.Status;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Fatinha de Sousa
 */
public class Util {

    private static final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String [] args) throws ParseException{
        System.out.println(new Date());
    }
    
    public static String parseDateString(Date data){
        return formatter.format(data);
    }
    
    public static Date parseStringDate(String data) throws ParseException{
        return formatter.parse(data);
    }
    
    public static Status verificaStatus(String status){
        if(status.equalsIgnoreCase("PAGO")){
            return Status.PAGO;
        }else{
            if(status.equalsIgnoreCase("VENCIDO")){
                return Status.VENCIDO;
            }else{
                return Status.A_VENCER;
            }
        }
    }
    
    public static Banco verificarBanco(String banco){
        if(banco.equalsIgnoreCase("BB")){
            return Banco.BB;
        }else{
            if(banco.equalsIgnoreCase("BRADESCO")){
                return Banco.BRADESCO;
            }else{
                return Banco.CEF;
            }
        }
    }
}
