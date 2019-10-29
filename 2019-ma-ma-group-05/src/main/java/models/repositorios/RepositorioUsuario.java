package models.repositorios;

import models.repositorios.DAOs.DAO;
import models.entities.Usuario;

import java.util.List;

public class RepositorioUsuario extends Repositorio {
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioUsuario(dao);
        }
        return instance;
    }

    private RepositorioUsuario(DAO dao){
        this.setDao(dao);
    }

    public List<Usuario> buscarTodos(){
        return (List<Usuario>)(List<?>) this.dao.buscarTodos();
    }

    public Usuario buscarPorId(int id){
        return (Usuario) this.dao.buscarPorId(id);
    }

    public Usuario buscarPorNombre(String nombre){ return (Usuario) this.dao.buscarPorNombre(nombre); }

}
