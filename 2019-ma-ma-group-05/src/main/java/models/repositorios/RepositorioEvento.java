package models.repositorios;

import models.entities.Evento;
import models.repositorios.DAOs.DAO;

import java.util.List;

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
    public List<Evento> buscarTodos(){ return (List<Evento>) (List<?>) this.dao.buscarTodos(); }

    public Evento buscarPorId(int id){ return (Evento) this.dao.buscarPorId(id);}

    public Evento buscarPorNombre(String nombre){ return (Evento) this.dao.buscarPorNombre(nombre); }
}
