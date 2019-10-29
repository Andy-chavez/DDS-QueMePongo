package models.repositorios;

import models.repositorios.DAOs.DAO;

public class RepositorioEvento extends Repositorio{
    private static RepositorioEvento instance;

    public RepositorioEvento() {
        this.setDao(DaoEvento.getInstance());
    }

    public static RepositorioEvento getInstance() {
        if(instance == null){
            instance = new RepositorioEvento();
        }
        return instance;
    }
    //todo override de varios metodos
}
