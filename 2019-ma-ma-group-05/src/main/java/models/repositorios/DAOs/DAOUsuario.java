package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Usuario;

import java.util.List;

public class DAOUsuario implements DAO {
    private static DAOUsuario instance;

    public static DAOUsuario getInstance() {
        if(instance == null){
            instance = new DAOUsuario();
        }
        return instance;
    }
    @Override
    public Usuario buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Usuario.class, id);
    }
    @Override
    public Usuario buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Usuario as u where u.nombre = '" + nombre + "'";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return (Usuario)listUsuarios.get(0);
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Usuario";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listUsuarios;
    }

}