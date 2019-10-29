package models.repositorios;

import models.entities.Tipo;
import models.repositorios.DAOs.DAO;
import models.repositorios.DAOs.DAOTipo;

import java.util.List;

public class RepositorioTipo extends Repositorio{
    private static RepositorioTipo instance;

    public static RepositorioTipo getInstance() {
        if(instance == null){
            instance = new RepositorioTipo(DAOTipo.getInstance());

        }
        return instance;
    }

    public RepositorioTipo(DAO dao) {
        this.setDao(dao);
    }

    public List<Tipo> buscarTodos(){ return (List<Tipo>) (List<?>) this.dao.buscarTodos(); }

    public Tipo buscarPorId(int id){ return (Tipo) this.dao.buscarPorId(id);}

    public Tipo buscarPorNombre(String nombre){ return (Tipo) this.dao.buscarPorNombre(nombre); }

    public void agregar(Object unObjeto){
        Tipo tipo = (Tipo)unObjeto;
        if(this.dao.buscarPorNombre(tipo.getNombre())== null){
            dao.agregar(tipo);
        }
    }
}