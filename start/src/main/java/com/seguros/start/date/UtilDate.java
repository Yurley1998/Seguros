package com.seguros.start.date;
import java.util.Date;

public class UtilDate {
    /**
     * Metodo que convierte un util.Date a sql.Date
     * @param date
     * @return
     */
    public static java.sql.Date toSqlDate(Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
}
