package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioCategoria extends Repositorio{
    private static RepositorioCategoria instance;

    public RepositorioCategoria(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioCategoria getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioCategoria(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}
