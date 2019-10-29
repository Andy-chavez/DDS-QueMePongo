package models.repositorios;

import models.entities.MoldeAtuendo;
import models.repositorios.DAOs.DAO;

import java.util.List;

public class RepositorioMolde extends Repositorio {
    private static RepositorioMolde instance;

    public RepositorioMolde() {
        this.setDao(DaoMoldeAtuendo.getInstance());
    }

    public static RepositorioMolde getInstance() {
        if(instance == null){
            instance = new RepositorioMolde();
        }
        return instance;
    }
    public List<MoldeAtuendo> obtenerMoldes(){
        return (List<MoldeAtuendo>)(List<?>)this.dao.buscarTodos();
    }

}
