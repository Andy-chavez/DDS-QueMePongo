package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.MoldeAtuendo;
import models.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DAOMoldeAtuendo implements DAO {
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(MoldeAtuendo.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
    	String query = "from MoldeAtuendo";
        List listMoldes = new ArrayList<MoldeAtuendo>();
        listMoldes =EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listMoldes;
    }

}
