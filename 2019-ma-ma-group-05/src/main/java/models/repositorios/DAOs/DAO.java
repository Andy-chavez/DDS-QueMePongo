package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Usuario;

import java.util.List;

public interface DAO {
    public Object buscarPorId(int id);
    public Object buscarPorNombre(String nombre);
    public List<Object> buscarTodos();
    public List<Object> buscarTodos(int id);
    default void modficar(Object o){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    };
    default void eliminar(Object o){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    };
    default void agregar(Object o){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    };

}
