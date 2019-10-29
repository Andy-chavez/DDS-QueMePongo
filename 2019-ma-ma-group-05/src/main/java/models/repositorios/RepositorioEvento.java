package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioEvento extends Repositorio{
    private static RepositorioEvento instance;

    public RepositorioEvento(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioEvento getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioEvento(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}
