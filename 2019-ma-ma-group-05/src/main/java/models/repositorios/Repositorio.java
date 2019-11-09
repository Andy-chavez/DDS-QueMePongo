package models.repositorios;

import models.repositorios.DAOs.DAO;

import java.util.List;

public abstract class Repositorio {
    protected DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void agregar(Object unObjeto){
        this.dao.agregar(unObjeto);
    }

    public void iniciarBase(){ }
    public void modficar(Object unObjeto){
        this.dao.modficar(unObjeto);
    }

    public void eliminar(Object unObjeto){
        this.dao.eliminar(unObjeto);
    }

}
