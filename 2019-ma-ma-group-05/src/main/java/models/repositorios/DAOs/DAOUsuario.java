package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Usuario;

import java.util.ArrayList;
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
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Usuario.class, id);
    }
    @Override
    public Object buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Usuario as u where u.nombre = '" + nombre + "'";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listUsuarios.get(0);
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Usuario";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listUsuarios;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }

}