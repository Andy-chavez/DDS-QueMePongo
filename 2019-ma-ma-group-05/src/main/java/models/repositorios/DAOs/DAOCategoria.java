package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Categoria;

import java.util.ArrayList;
import java.util.List;

public class DAOCategoria implements DAO {
    private static DAOCategoria instance;

    public static DAOCategoria getInstance() {
        if(instance == null){
            instance = new DAOCategoria();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Categoria.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
    	String query = "from Categoria as c where c.nombre = '" + nombre + "'";
        List categorias =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return categorias.get(0);
    }

    @Override
    public List<Object> buscarTodos() {
    	String query = "from Categoria";
        List categorias =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return categorias;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }
}
