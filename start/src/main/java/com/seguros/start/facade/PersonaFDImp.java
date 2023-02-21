package com.seguros.start.facade;

import com.seguros.start.bd.Conexion;
import com.seguros.start.bd.MgConexion;
import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.FdExceptions;
import com.seguros.start.exceptions.MgExceptions;
import com.seguros.start.manager.PersonaMGImp;
import com.seguros.start.manager.PersonaMg;

import java.sql.SQLException;
import java.util.ArrayList;


public class PersonaFDImp implements PersonaFd{

    private static PersonaFDImp PersonaFD;
    private PersonaMg PersonaMG;

    private PersonaFDImp(){
        this.PersonaMG = PersonaMGImp.getPersonaMG();
    }
    public static PersonaFDImp getPersonaFD(){
        if (PersonaFD == null){
            PersonaFD = new PersonaFDImp();
        }
        return PersonaFD;
    }
    public void create(Personas personas) throws FdExceptions {
        Conexion conectar = null;
        MgConexion mgConexion = null;
        try{
            mgConexion = MgConexion.getInstance();
            conectar = mgConexion.getConexion(); //pido una conexión libre
            this.PersonaMG.save(personas, conectar);
            conectar.getConectar().commit(); // si es exitoso
        }catch(MgExceptions mg){
            try{
                conectar.getConectar().rollback();
            }catch (SQLException se){
                throw new RuntimeException(se);
            }
            throw new FdExceptions(mg);
        }catch(Exception e){
            try{
                conectar.getConectar().rollback();
            }catch(SQLException se){
                throw new FdExceptions(e);
            }finally{
                mgConexion.close(conectar);
            }
        }

    }
    public ArrayList<Personas> selectAll() throws FdExceptions {
        Conexion conectar = null;
        MgConexion managerConnect = null;
        try {
            managerConnect = MgConexion.getInstance();
            conectar = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");

            return this.PersonaMG.selectAll(conectar);

        } catch (MgExceptions mex) {
            throw new FdExceptions(mex);
        } catch (Exception ex) {
            throw new FdExceptions(ex);
        }finally {
            managerConnect.close(conectar);
        }
    }
    public void delete(Personas personas) throws FdExceptions{
        Conexion conectar = null;
        MgConexion mgConexion = null;
        try{

            mgConexion = MgConexion.getInstance();
            conectar = mgConexion.getConexion(); //se pide una conexión libre
            this.PersonaMG.delete(personas, conectar);
            conectar.getConectar().commit(); //si es exitoso
        }catch(MgExceptions mg){
            try{
                conectar.getConectar().rollback(); // si falla devuelve todo
            }catch(SQLException se){
                throw new RuntimeException(se);
            }
            throw new FdExceptions(mg);
        }catch(Exception e){
            try{
                conectar.getConectar().rollback(); //si falla deivuelve todo
            }catch(SQLException se){
                throw  new RuntimeException(se);
            }
            throw new FdExceptions(e);
        }finally {
            {
                mgConexion.close(conectar);
            }
        }


    }
    public void update(Personas personas) throws FdExceptions{
        Conexion conectar = null;
        MgConexion mgConexion = null;
        try{
            mgConexion = MgConexion.getInstance();
            conectar =  mgConexion.getConexion();//pido conexión libre
            this.PersonaMG.update(personas, conectar);
            conectar.getConectar().commit();//si es exitoso
        }catch (MgExceptions mg){
            try{
                conectar.getConectar().rollback();//si falla devuelve todo
            }catch (SQLException se){
                throw new RuntimeException(se);
            }
            throw new FdExceptions(mg);
        }catch (Exception e){
            try{
                conectar.getConectar().rollback();//si falla devuelve todo
            }catch (SQLException se){
                throw new RuntimeException(se);
            }
            throw new FdExceptions(e);
        }finally {
            mgConexion.close(conectar);
        }

    }
}
