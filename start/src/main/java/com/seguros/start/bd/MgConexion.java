package com.seguros.start.bd;

import java.util.ArrayList;

public class MgConexion {
    private static MgConexion mgConexion;
    private ArrayList<Conexion> con;
    private MgConexion(){
        con = new ArrayList<>();
    }
    public static MgConexion getInstance(){
        if (mgConexion == null){
            mgConexion = new MgConexion();
        }
        return mgConexion;
    }
    public void open(){
        for (int i =0; i<10; i++){
            Conexion conectar = new Conexion();
            conectar.open();
            con.add(conectar);
            System.out.println(conectar);
        }
    }
    public void close(Conexion conectar){
        conectar.setFree(true);

    }
    public Conexion getConexion(){
            Conexion co = null;
            for (int i=0; i<10; i++){
                co= con.get(i);
                if (co.getFree()){
                    co.setFree(false);
                }
            }
            return co;

    }
}
