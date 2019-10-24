package models.DAOs;

import bd.EntityManagerHelper;
import models.entities.Usuario;

import java.util.List;

public class DAOUsuario implements DAO {
    @Override
    public Usuario buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Usuario.class, id);
    }
    @Override
    public Usuario buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Usuario as u where u.nombre = '" + nombre + "'";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return (Usuario)listUsuarios.get(0);
    }
    @Override
    public void modficarPorId(int id, Object o) {
        this.eliminar(this.buscarPorId(id));
        this.agregar(o);
    }
    @Override
    public List<Object> buscarTodos() {
        String query = "from Usuario";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listUsuarios;
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