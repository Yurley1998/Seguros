package com.seguros.start.facade;
import com.seguros.start.bd.Conexion;

import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.FdExceptions;

import java.util.ArrayList;

public interface PersonaFd {
    public void create(Personas personas) throws FdExceptions;
    public ArrayList<Personas> selectAll() throws FdExceptions;

    public void delete(Personas personas) throws FdExceptions;
    public void update(Personas personas) throws FdExceptions;

}
