package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.ColorPersistible;

import java.util.List;

public class DAOColorPersistible implements DAO {
    private static DAOColorPersistible instance;

    public static DAOColorPersistible getInstance() {
        if(instance == null){
            instance = new DAOColorPersistible();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(ColorPersistible.class, id);
    }

    @Override
    public Object buscarPorNombre(String hex) { //le pongo ese nombre solo para hacerlo polimorfico pero basicamente es buscar por id
        String query = "from ColorPersistible as c where c.hex = '" + hex + "'";
        List color =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return color.get(0);
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from ColorPersistible";
        List colores =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return colores;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }
}
