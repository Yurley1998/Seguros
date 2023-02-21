package com.seguros.start.dao;

import com.seguros.start.bd.Conexion;
import com.seguros.start.date.UtilDate;
import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.DaoExceptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAOImp implements PersonaDao{
    private static PersonaDAOImp PersonaDAO;
    private PersonaDAOImp(){

    }
    public static PersonaDAOImp getInstance(){
        if (PersonaDAO == null){
            PersonaDAO = new PersonaDAOImp();
        }
        return PersonaDAO;
    }

    public void insert(Personas personas, Conexion conectar) throws DaoExceptions {
        String INSERT= "INSERT INTO personas(\n" +
                "\tnombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento, fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try{
            statement = conectar.getConectar().prepareStatement(INSERT);
            statement.setString(1, personas.getNombre1());
            statement.setString(2, personas.getNombre2());
            statement.setString(3, personas.getApellido1());
            statement.setString(4, personas.getApellido2());
            statement.setString(5, personas.getTipoDocumento());
            statement.setInt(6, personas.getNumDocumento());
            statement.setDate(7, UtilDate.toSqlDate(personas.getFechaNacimiento()));
            statement.setString(8, personas.getProfesion());
            statement.setString(9, personas.getEmail());
            statement.setString(10, personas.getNumTelefono());
            statement.setString(11, personas.getSexo());
            statement.setDouble(12, personas.getSalario());
            statement.setString(13, personas.getEstadoCivil());
            statement.executeUpdate();
        }catch(SQLException se){
            throw new DaoExceptions(se);
        }catch(Exception ex){
            throw new DaoExceptions(ex);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        System.out.println("Insertado");

    }
    public Personas getById(Personas personas, Conexion conectar) throws DaoExceptions{
        String SQL = "SELECT id_persona, nombre1, nombre2, apellido1, apellido2, tipo_documento, num_documento, fecha_nacimiento, profesion, correo, telefono, sexo, salario, estado_civil\n" +
                "\tFROM personas WHERE id_persona=?";
        PreparedStatement statement=null;
        ResultSet rs = null;
        Personas result = null;
        try{
            statement= conectar.getConectar().prepareStatement(SQL);
            statement.setInt(1, personas.getIdPersona());
            rs = statement.executeQuery();
            if (rs != null){
                while(rs.next()){
                    result= new Personas();
                    result.setNombre1(rs.getString("nombre1"));
                    result.setApellido1(rs.getString("apellido1"));

                }
            }
            return result;

        }catch(Exception ex){
            throw new DaoExceptions(ex);
        }finally{
            try{
                rs.close();
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }



    public ArrayList<Personas> getAll(Conexion conectar) throws DaoExceptions{
        String SQL = "SELECT nombre1,apellido2" +
                " FROM personas";
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Personas> listaPersonas = new ArrayList<>();
        try{
            statement = conectar.getConectar().prepareStatement(SQL);
            rs= statement.executeQuery();
            if (rs != null){
                while (rs.next()){
                    Personas result = new Personas();
                    result.setNombre1(rs.getString("nombre1"));
                    result.setApellido1(rs.getString("apellido2"));
                    listaPersonas.add(result);
                }
            }
            return listaPersonas;
        }catch(Exception ex){
            throw new DaoExceptions(ex);
        }finally {
            try{
                rs.close();
                statement.close();

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
    public void delete(Personas personas) throws DaoExceptions{
        try{
            System.out.println("Borrando a: "+personas.getNombre1());

        }catch(Exception e){
            throw new DaoExceptions(e);
        }
    }
    public void update(Personas personas, Conexion conectar) throws DaoExceptions{
        String UPDATE = "UPDATE personas\n" +
                "\tSET nombre1=?, nombre2=?, apellido1=?, apellido2=?, tipo_documento=?, num_documento=?, fecha_nacimiento=?, profesion=?, correo=?, telefono=?, sexo=?, salario=?, estado_civil=?\n" +
                "\tWHERE id_persona=?";
        PreparedStatement statement = null;
        try{
            statement = conectar.getConectar().prepareStatement(UPDATE);
            statement.setString(1, personas.getNombre1());
            statement.setString(2, personas.getNombre2());
            statement.setString(3, personas.getApellido1());
            statement.setString(4, personas.getApellido2());
            statement.setString(5, personas.getTipoDocumento());
            statement.setInt(6, personas.getNumDocumento());
            statement.setDate(7, UtilDate.toSqlDate(personas.getFechaNacimiento()));
            statement.setString(8, personas.getProfesion());
            statement.setString(9, personas.getEmail());
            statement.setString(10, personas.getNumTelefono());
            statement.setString(11, personas.getSexo());
            statement.setDouble(12, personas.getSalario());
            statement.setString(13, personas.getEstadoCivil());
            statement.setInt(14, personas.getIdPersona());
            statement.executeUpdate();
        }catch(SQLException se){
            throw new DaoExceptions(se);

        }catch(Exception ex){
            throw new DaoExceptions(ex);
        }finally{
            if (statement != null){
                try{
                    statement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

    }
}
