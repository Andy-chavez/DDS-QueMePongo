package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Guardarropa;

import java.util.List;

public class DAOGuardarropa implements DAO {
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
    public void modficarPorId(int id, Object o) {
        this.eliminar(this.buscarPorId(id));
        this.agregar(o);
    }
    @Override
    public List<?> buscarTodos() {
        String query = "from Guardarropa";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa;
    }
    @Override
    public void eliminar(Object o) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }
    @Override
    public void agregar(Object o) { //TODO verificar que no se guarden en caso de ya haber algo de caracteristicas parecidas
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }
}