package com.br.util;

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
    
    public static String parseDateString(Date data){
        return formatter.format(data);
    }
    
    public static Date parseStringDate(String data) throws ParseException{
        return formatter.parse(data);
    }
}
