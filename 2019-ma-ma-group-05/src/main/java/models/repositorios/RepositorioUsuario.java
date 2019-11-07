package models.repositorios;

import models.repositorios.DAOs.DAO;
import models.entities.Usuario;
import models.repositorios.DAOs.DAOUsuario;

import javax.transaction.Transactional;
import java.util.List;

public class RepositorioUsuario extends Repositorio {
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance() {
        if(instance == null){
            instance = new RepositorioUsuario(DAOUsuario.getInstance());

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


    @Override
    public void agregar(Object unObject){
        Usuario u = (Usuario) unObject;
        if(u.getGuardarropas()!=null){
            u.getGuardarropas().forEach(guardarropa -> {RepositorioGuardarropa.getInstance().recorrerPrendas(guardarropa);});
        }
        dao.agregar(u);
    }
}
