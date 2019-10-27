package models.repositorios;

import models.repositorios.DAOs.DAO;

public abstract class Repositorio {
    protected DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void agregar(Object unObjeto){
        this.dao.agregar(unObjeto);
    }

    public void modficarPorId(int id,Object unObjeto){
        this.dao.modficarPorId(id, unObjeto);
    }

    public void eliminar(Object unObjeto){
        this.dao.eliminar(unObjeto);
    }
}
