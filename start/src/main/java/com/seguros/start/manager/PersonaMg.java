package com.seguros.start.manager;

import com.seguros.start.bd.Conexion;
import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.MgExceptions;

import java.util.ArrayList;

public interface PersonaMg {
    public void save(Personas personas, Conexion conectar) throws MgExceptions;
    public ArrayList<Personas> selectAll(Conexion conectar) throws MgExceptions;
    public void delete(Personas personas, Conexion conectar) throws MgExceptions;
    public void update(Personas personas, Conexion conectar) throws MgExceptions;
}
