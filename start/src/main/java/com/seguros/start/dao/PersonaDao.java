package com.seguros.start.dao;

import com.seguros.start.bd.Conexion;
import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.DaoExceptions;

import java.util.ArrayList;

public interface PersonaDao {
    public void insert(Personas personas, Conexion conectar) throws DaoExceptions;
    public Personas getById(Personas personas, Conexion conectar) throws DaoExceptions;
    public ArrayList<Personas> getAll(Conexion conectar) throws DaoExceptions;
    public void delete(Personas personas) throws DaoExceptions;
    public void update(Personas personas, Conexion conectar) throws DaoExceptions;

}
