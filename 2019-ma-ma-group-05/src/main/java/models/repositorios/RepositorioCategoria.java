package models.repositorios;

import models.repositorios.DAOs.DAOCategoria;

public class RepositorioCategoria extends Repositorio{
    private static RepositorioCategoria instance;

    public RepositorioCategoria() {
        this.setDao(DAOCategoria.getInstance());
    }

    public static RepositorioCategoria getInstance() {
        if(instance == null){
            instance = new RepositorioCategoria();
        }
        return instance;
    }
    //todo override de varios metodos
}
