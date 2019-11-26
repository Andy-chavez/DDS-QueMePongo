package models.repositorios.DAOs;

import com.google.gson.internal.$Gson$Preconditions;
import db.EntityManagerHelper;
import models.entities.Categorias.*;
import models.entities.Prenda;
import models.entities.Tela;
import models.entities.Tipo;
import models.repositorios.RepositorioCategoria;
import org.hibernate.annotations.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Tipo> buscarPorCategoria(String categoria){
        List<Tipo> tipos = (List<Tipo>)(List<?>) this.buscarTodos();
 //       String filtro = "Superior";
//        if (categoria.contains("Superior")){
//            categoria = "Superior";
//        };
        List<Tipo> tipaso = tipos.stream()
                .filter(tipo -> "Superior".equals(tipo.getCategoria().getNombre()))
//                .filter(tipo ->  categoria.equals(tipo.getCategoria().getNombre()))
                .collect(Collectors.toList());
//        EntityManagerHelper.closeEntityManager();
        return tipaso;
    }
}
