package models.repositorios;

import models.entities.Tela;
import models.repositorios.DAOs.DAOTela;

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
        this.setDao(DAOTela.getInstance());
    }

    public List<Tela> buscarTodos(){ return (List<Tela>) (List<?>) this.dao.buscarTodos(); }

    public Tela buscarPorId(int id){ return (Tela) this.dao.buscarPorId(id);}

    public Tela buscarPorNombre(String nombre){ return (Tela) this.dao.buscarPorNombre(nombre); }

    public void agregar(Object unObjeto){
        Tela tela = (Tela)unObjeto;
        if(this.dao.buscarPorNombre(tela.getNombre())== null){
            dao.agregar(tela);
        }
    }

}
