package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Prenda;

import java.util.List;

public class DAOPrenda implements DAO {
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
        return null;
    }
}
