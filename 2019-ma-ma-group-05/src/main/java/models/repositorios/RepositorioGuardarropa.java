package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioGuardarropa extends Repositorio {
    private static RepositorioGuardarropa instance;

    public RepositorioGuardarropa(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioGuardarropa getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioGuardarropa(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}
