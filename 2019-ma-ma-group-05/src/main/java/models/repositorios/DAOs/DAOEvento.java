package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Evento;

import java.util.List;

public class DAOEvento implements DAO {
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Evento.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
    	String query = "from Evento as e where e.nombre = '" + nombre + "'";
        List eventos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return (Evento)eventos.get(0);
    }

    @Override
    public List<Object> buscarTodos() {
    	String query = "from Evento";
        List eventos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
    	return eventos;
    }
}
