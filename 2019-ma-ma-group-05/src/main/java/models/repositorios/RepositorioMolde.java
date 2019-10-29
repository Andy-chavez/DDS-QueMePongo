package models.repositorios;

import models.entities.MoldeAtuendo;
import models.repositorios.DAOs.DAO;

import java.util.List;

public class RepositorioMolde extends Repositorio {
    private static RepositorioMolde instance;

    public RepositorioMolde(DAO dao) {
        this.setDao(dao);
    }

    public static RepositorioMolde getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioMolde(dao);
        }
        return instance;
    }
    public List<MoldeAtuendo> obtenerMoldes(){
        return (List<MoldeAtuendo>)(List<?>)this.dao.buscarTodos();
    }

    public MoldeAtuendo buscarPorId(int id){ return (MoldeAtuendo) this.dao.buscarPorId(id); }

    public MoldeAtuendo buscarPorNombre(String nombre){ return (MoldeAtuendo) this.dao.buscarPorNombre(nombre); }
}
