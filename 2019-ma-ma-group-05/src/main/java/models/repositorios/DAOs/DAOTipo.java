package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Categorias.*;
import models.entities.Prenda;
import models.entities.Tela;
import models.entities.Tipo;

import java.util.ArrayList;
import java.util.List;

public class DAOTipo implements DAO {
    private static DAOTipo instance;

    public static DAOTipo getInstance() {
        if(instance == null){
            instance = new DAOTipo();
        }
        return instance;
    }

    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Tipo.class, id);
    }

    @Override
    public Object buscarPorNombre(String nombre) {
        //obtiene el primer resultado en caso de haber varios
        String query = "from Tipo as u where u.nombre = '" + nombre + "'";
        List listTipos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        if(listTipos.size()>0){
            return listTipos.get(0);
        }
        return null;
    }

    @Override
    public List<Object> buscarTodos() {
        String query = "from Tipo";
        List listTipos =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listTipos;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        return null;
    }

    public List<Prenda> buscarPorCategoria(String categoria){
        String query = "SELECT tc.nombre,tt.nombre FROM quemepongo.tipo tt, quemepongo.categoria tc " +
                            "WHERE tc.id=tt.categoria_id AND tc.nombre='"+categoria+"'";
        List tipos = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        return tipos;
    }
}
