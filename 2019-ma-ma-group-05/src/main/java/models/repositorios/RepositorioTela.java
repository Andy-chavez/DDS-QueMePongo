package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioTela extends Repositorio {
    private static RepositorioTela instance;

    public RepositorioTela(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioTela getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioTela(dao);
        }
        return instance;
    }
    //todo override de varios metodos
}
