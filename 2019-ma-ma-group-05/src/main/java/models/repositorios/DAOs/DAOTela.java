package models.repositorios.DAOs;

import bd.EntityManagerHelper;
import models.entities.Tela;
import models.entities.Usuario;

import java.util.List;

public class DAOTela implements DAO {
    public void iniciarBase(){
        Tela algodon = new Tela("Algodon");
        Tela cuero = new Tela("Cuero");
        Tela elastina = new Tela ("Elastina");
        Tela encaje = new Tela ("Encaje");
        Tela nylon = new Tela("Nylon");
        Tela poliester = new Tela("Poliester");
        Tela seda = new Tela("Seda");
        this.agregar(algodon);
        this.agregar(cuero);
        this.agregar(elastina);
        this.agregar(encaje);
        this.agregar(nylon);
        this.agregar(poliester);
        this.agregar(seda);
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Tela.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        String query = "from Tela as t where t.nombre = '" + nombre + "'";
        List listUsuarios =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return (Tela)listUsuarios.get(0);
    }

    @Override
    public List<Usuario> buscarTodos() {
        String query = "from Tela";
        List listTelas =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listTelas;
    }

    @Override
    public void modficarPorId(int id, Object o) {
        this.eliminar(this.buscarPorId(id));
        this.agregar(o);
    }
    @Override
    public void eliminar(Object o) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    @Override
    public void agregar(Object o) {//TODO verificar que no se guarden en caso de ya haber algo de caracteristicas parecidas
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }
}
