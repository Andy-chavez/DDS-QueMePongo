package models.repositorios;

import models.entities.ColorPersistible;
import models.repositorios.DAOs.DAOColorPersistible;

import java.awt.*;
import java.util.List;

public class RepositorioColor extends Repositorio{
    private static RepositorioColor instance;

    public RepositorioColor() {
        this.setDao(DAOColorPersistible.getInstance());
    }

    public static RepositorioColor getInstance() {
        if(instance == null){
            instance = new RepositorioColor();
        }
        return instance;
    }

    @Override
    public void agregar(Object unObjeto){
        ColorPersistible color = (ColorPersistible) unObjeto;
        if(this.dao.buscarPorNombre(color.getHex())== null){
            dao.agregar(color);
        }
    }
    public List<ColorPersistible> buscarTodos(){ return (List<ColorPersistible>) (List<?>) this.dao.buscarTodos(); }

    public ColorPersistible buscarPorId(int id){ return (ColorPersistible) this.dao.buscarPorId(id);}

    public ColorPersistible buscarPorNombre(String hex){ return (ColorPersistible) this.dao.buscarPorNombre(hex); }

}
