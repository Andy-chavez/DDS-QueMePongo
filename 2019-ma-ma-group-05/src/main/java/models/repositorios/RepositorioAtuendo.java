package models.repositorios;

import models.entities.Atuendo;
import models.repositorios.DAOs.DAOAtuendo;

import java.util.List;

public class RepositorioAtuendo extends Repositorio{
    private static RepositorioAtuendo instance;

    public RepositorioAtuendo() {
        this.setDao(DAOAtuendo.getInstance());
    }

    public static RepositorioAtuendo getInstance() {
        if(instance == null){
            instance = new RepositorioAtuendo();
        }
        return instance;
    }
    @Override
    public void agregar(Object unObjeto){
        Atuendo atuendo = (Atuendo)unObjeto;
        dao.agregar(atuendo);
    }
    //Busca atuendos aceptados por id de usuario
    public List<Atuendo> buscarTodos(int id){ return (List<Atuendo>) (List<?>) this.dao.buscarTodos(id); }
    public Atuendo buscarPorId(int id){ return (Atuendo) this.dao.buscarPorId(id);}


}
