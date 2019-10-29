package models.repositorios;

import models.entities.Guardarropa;
import models.repositorios.DAOs.DAO;

import java.util.List;

public class RepositorioGuardarropa extends Repositorio {
    private static RepositorioGuardarropa instance;

    public static RepositorioGuardarropa getInstance() {
        if(instance == null){
            instance = new RepositorioGuardarropa();
        }
        return instance;
    }
    public RepositorioGuardarropa() {
        this.setDao(DaoGuardarropa.getInstance());
    }
    public List<Guardarropa> buscarTodos(){ return (List<Guardarropa>) (List<?>) this.dao.buscarTodos(); }

    public Guardarropa buscarPorId(int id){ return (Guardarropa) this.dao.buscarPorId(id); }

    public Guardarropa buscarPorNombre(String nombre){ return (Guardarropa) this.dao.buscarPorNombre(nombre); }
}
