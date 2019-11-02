package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Guardarropa;

import java.util.ArrayList;
import java.util.List;

public class DAOGuardarropa implements DAO {
    private static DAOGuardarropa instance;

    public static DAOGuardarropa getInstance() {
        if(instance == null){
            instance = new DAOGuardarropa();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Guardarropa.class, id);
    }
    @Override
    public Object buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Guardarropa as g where g.nombre = '" + nombre + "'";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa.get(0);
    }
    @Override
    public List<Object> buscarTodos() {
        String query = "from Guardarropa";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa;
    }

    @Override
    public List<Object> buscarTodos(int id) { //todo escribir el override
        return null;
    }
}