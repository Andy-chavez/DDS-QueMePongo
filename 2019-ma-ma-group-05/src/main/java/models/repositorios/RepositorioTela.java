package models.repositorios;

import models.entities.Tela;
import models.repositorios.DAOs.DAO;

import java.util.List;

public class RepositorioTela extends Repositorio {
    private static RepositorioTela instance;

    public static RepositorioTela getInstance() {
        if(instance == null){
            instance = new RepositorioTela();
        }
        return instance;
    }

    public RepositorioTela() {
        this.setDao(DaoTela.getInstance());
    }

    public List<Tela> buscarTodos(){ return (List<Tela>) (List<?>) this.dao.buscarTodos(); }

    public Tela buscarPorId(int id){ return (Tela) this.dao.buscarPorId(id);}

    public Tela buscarPorNombre(String nombre){ return (Tela) this.dao.buscarPorNombre(nombre); }

}
