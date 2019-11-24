package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Atuendo;

import java.util.List;

public class DAOAtuendo implements DAO {
    private static DAOAtuendo instance;

    public static DAOAtuendo getInstance() {
        if(instance == null){
            instance = new DAOAtuendo();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Atuendo.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        return null;
    }

    @Override
    public List<Object> buscarTodos(int id) {

        String query = "from Atuendo where usuario_id ="+id+" and rechazado = 0";
        List atuendos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return atuendos;
    }
}
