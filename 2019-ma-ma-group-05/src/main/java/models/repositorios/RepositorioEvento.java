package models.repositorios;

import models.entities.Evento;
import models.repositorios.DAOs.DAOEvento;

import java.util.List;

public class RepositorioEvento extends Repositorio{
    private static RepositorioEvento instance;

    public RepositorioEvento() {
        this.setDao(DAOEvento.getInstance());
    }

    public static RepositorioEvento getInstance() {
        if(instance == null){
            instance = new RepositorioEvento();
        }
        return instance;
    }
    public List<Evento> buscarTodos(){ return (List<Evento>) (List<?>) this.dao.buscarTodos(); }

    public Evento buscarPorId(int id){ return (Evento) this.dao.buscarPorId(id);}

    public Evento buscarPorNombre(String nombre){ return (Evento) this.dao.buscarPorNombre(nombre); }
}
