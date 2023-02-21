package com.seguros.start.manager;

import com.seguros.start.bd.Conexion;
import com.seguros.start.bd.MgConexion;
import com.seguros.start.dao.PersonaDAOImp;
import com.seguros.start.dao.PersonaDao;
import com.seguros.start.dto.Personas;
import com.seguros.start.exceptions.DaoExceptions;
import com.seguros.start.exceptions.MgExceptions;

import java.util.ArrayList;

public class PersonaMGImp implements PersonaMg{
    private PersonaDao PersonaDAO;
    private static PersonaMGImp PersonaMG;
    private PersonaMGImp(){
        this.PersonaDAO= PersonaDAOImp.getInstance();
    }
    public static PersonaMGImp getPersonaMG(){
        if (PersonaMG == null){
            PersonaMG = new PersonaMGImp();
        }
        return PersonaMG;
    }
    public void save(Personas personas, Conexion conectar) throws MgExceptions {
        try{
            Personas temp = this.PersonaDAO.getById(personas, conectar);
            if (temp == null){
                this.PersonaDAO.insert(personas, conectar);
            }else{
                this.PersonaDAO.update(personas, conectar);
            }
        }catch(DaoExceptions dao){
            throw new MgExceptions(dao);
        }catch(Exception ex){
            throw new MgExceptions(ex);
        }
    }
    public void select(Personas personas){

    }
    public ArrayList<Personas> selectAll(Conexion conectar) throws MgExceptions{

        try{

            return this.PersonaDAO.getAll(conectar);

        }catch(DaoExceptions dao){
            throw new MgExceptions(dao);
        }catch(Exception ex){
            throw new MgExceptions(ex);
        }
    }
    public void delete(Personas personas, Conexion conectar) throws MgExceptions{
        try{
            Personas temp= this.PersonaDAO.getById(personas, conectar);
            if (temp != null){
                this.PersonaDAO.delete(personas);
            }
        }catch(DaoExceptions dao){
            throw new MgExceptions(dao);

        }catch(Exception ex){
            throw new MgExceptions(ex);
        }
    }
    public void update(Personas personas, Conexion conectar) throws MgExceptions {
        try{
            Personas temp = this.PersonaDAO.getById(personas, conectar);
            if (temp!=null){
                this.PersonaDAO.update(personas, conectar);
            }
        }catch(DaoExceptions dao){
            throw new MgExceptions(dao);
        }catch (Exception ex){
            throw new MgExceptions(ex);
        }
    }
}
