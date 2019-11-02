package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Tela;

import java.util.ArrayList;
import java.util.List;

public class DAOTela implements DAO {
    private static DAOTela instance;

    public static DAOTela getInstance() {
        if(instance == null){
            instance = new DAOTela();
        }
        return instance;
    }
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
        List listTelas =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        if(listTelas.size()>0){
            return listTelas.get(0);
        }
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Tela";
        List listTelas =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listTelas;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }

}
