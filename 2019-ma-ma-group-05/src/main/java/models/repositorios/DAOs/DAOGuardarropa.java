package models.repositorios.DAOs;

import db.EntityManagerHelper;
import models.entities.Guardarropa;

import java.util.ArrayList;
import java.util.List;

public class DAOGuardarropa implements DAO {
    private static DAOGuardarropa instance;

    public static DAOGuardarropa getInstance() {
        if(instance == null){
            instance = new DAOGuardarropa();
        }
        return instance;
    }
    @Override
    public Object buscarPorId(int id) {
        return EntityManagerHelper.getEntityManager().find(Guardarropa.class, id);
    }
    @Override
    public Object buscarPorNombre(String nombre) { //obtiene el primer resultado en caso de haber varios
        String query = "from Guardarropa as g where g.nombre = '" + nombre + "'";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        if(listGuardarropa.size()>0){
            return listGuardarropa.get(0);
        }
        return null;

    }
    @Override
    public List<Object> buscarTodos() {
        String query = "from Guardarropa";
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa;
    }

    @Override
    public List<Object> buscarTodos(int id) {
        String query = "select g.id, g.nombre, u.usuario_id,a.id as atuendo_id, p.id as prenda_id from Guardarropa as g \n" +
                "\tleft join usuario_guardarropa as u on u.guardarropas_id = g.id\n" +
                " left join Atuendo as a on a.guardarropa_id = g.id " +
                "left join Prenda as p on p.guardarropa_id = g.id\n" +
                "\twhere u.usuario_id ="+id;
        List listGuardarropa =  EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
        EntityManagerHelper.closeEntityManager();
        return listGuardarropa;
    }
}