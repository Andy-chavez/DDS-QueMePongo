package models.repositorios;

import models.entities.Prenda;
import models.repositorios.DAOs.DAOPrenda;

import java.util.List;

public class RepositorioPrenda extends Repositorio {
    private static RepositorioPrenda instance;

    public static RepositorioPrenda getInstance() {
        if(instance == null){
            instance = new RepositorioPrenda();
        }
        return instance;
    }

    public RepositorioPrenda() {
        this.setDao(DAOPrenda.getInstance());
    }

    public List<Prenda> buscarTodos(){ return (List<Prenda>) (List<?>) this.dao.buscarTodos(); }

    public Prenda buscarPorId(int id){ return (Prenda) this.dao.buscarPorId(id);}
}
