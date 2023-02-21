package com.seguros.start.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection conectar;
    private Boolean Free=true;

    public Connection getConectar() {
        return conectar;
    }

    public void setConectar(Connection conectar) {
        this.conectar = conectar;
    }

    public Boolean getFree() {
        return Free;
    }

    public void setFree(Boolean free) {
        Free = free;
    }

    public void open(){
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/seguros",
                    "postgres", "Yurley");
            conectar.setAutoCommit(false); //Defino que yo soy el que controlo la transaccion
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
