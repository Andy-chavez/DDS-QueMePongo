package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Guardarropa;

import java.util.List;

public class DAOGuardarropa implements DAO {
    private static DAOGuardarropa instance;

    public static DAOGuardarropa getInstance(DAO dao) {
        if(instance == null){
            instance = new DAOGuardarropa();
        }
        return instance;
    }
    @Override
    public Guardarropa buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Guardarropa.class, id);
    }
    @Override
    public Guardarropa buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Guardarropa as g where g.nombre = '" + nombre + "'";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return (Guardarropa) listGuardarropa.get(0);
    }
    @Override
    public List<Object> buscarTodos() {
        String query = "from Guardarropa";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa;
    }
}