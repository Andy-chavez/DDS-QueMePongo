package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Categoria;

import java.util.List;

public class DAOCategoria implements DAO {
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
