package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Evento;

import java.util.ArrayList;
import java.util.List;

public class DAOEvento implements DAO {
    private static DAOEvento instance;

    public static DAOEvento getInstance() {
        if(instance == null){
            instance = new DAOEvento();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Evento.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
    	String query = "from Evento as e where e.nombre = '" + nombre + "'";
        List eventos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        if(eventos.size()>0){
            return eventos.get(0);
        }
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Evento";
        List listEvento =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listEvento;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        String query = "from Evento where usuario_id = "+ id;
        List listEvento =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listEvento;
    }
}
