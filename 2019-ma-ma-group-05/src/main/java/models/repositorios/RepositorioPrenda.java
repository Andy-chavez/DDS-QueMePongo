package models.repositorios;

import models.entities.Prenda;
import models.repositorios.DAOs.DAO;

import java.util.List;

public class RepositorioPrenda extends Repositorio {
    private static RepositorioPrenda instance;

    public static RepositorioPrenda getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioPrenda(dao);
        }
        return instance;
    }

    public RepositorioPrenda(DAO dao) {
        this.setDao(dao);
    }

    public List<Prenda> buscarTodos(){ return (List<Prenda>) (List<?>) this.dao.buscarTodos(); }

    public Prenda buscarPorId(int id){ return (Prenda) this.dao.buscarPorId(id);}
}
