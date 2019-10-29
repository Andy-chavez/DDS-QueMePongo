package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioPrenda extends Repositorio {
    private static RepositorioPrenda instance;

    public RepositorioPrenda(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioPrenda getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioPrenda(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}
