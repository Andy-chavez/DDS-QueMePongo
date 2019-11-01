package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Prenda;

import java.util.ArrayList;
import java.util.List;

public class DAOPrenda implements DAO {
    private static DAOPrenda instance;

    public static DAOPrenda getInstance() {
        if(instance == null){
            instance = new DAOPrenda();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Prenda.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
    	return null;
    }

    @Override
    public List<Object> buscarTodos() {
    	String query = "from Prenda";
        List prendas =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return prendas;
    }
}
