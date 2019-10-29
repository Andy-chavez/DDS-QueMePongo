package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Categoria;

import java.util.List;

public class DAOCategoria implements DAO {
    private static DAOCategoria instance;

    public static DAOCategoria getInstance(DAO dao) {
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
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        return null;
    }
}
