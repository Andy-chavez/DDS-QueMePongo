package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioTipo extends Repositorio{
    private static RepositorioTipo instance;

    public RepositorioTipo(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioTipo getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioTipo(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}