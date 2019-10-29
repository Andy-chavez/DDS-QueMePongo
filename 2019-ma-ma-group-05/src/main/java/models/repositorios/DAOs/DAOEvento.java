package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Evento;

import java.util.ArrayList;
import java.util.List;

public class DAOEvento implements DAO {
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Evento.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Evento";
        List listEvento = new ArrayList<Evento>();
        listEvento =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listEvento;
    }
}
