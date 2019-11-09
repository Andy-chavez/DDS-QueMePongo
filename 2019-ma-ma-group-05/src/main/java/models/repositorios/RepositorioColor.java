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
    @Override
    public void iniciarBase(){ //Se podrian ir agregando mas
        this.agregar(ColorPersistible.black);
        this.agregar(ColorPersistible.green);
        this.agregar(ColorPersistible.blue);
        this.agregar(ColorPersistible.red);
        this.agregar(ColorPersistible.pink);
        this.agregar(ColorPersistible.orange);
        this.agregar(ColorPersistible.yellow);
    }
    public List<ColorPersistible> buscarTodos(){ return (List<ColorPersistible>) (List<?>) this.dao.buscarTodos(); }

    public ColorPersistible buscarPorId(int id){ return (ColorPersistible) this.dao.buscarPorId(id);}

    public ColorPersistible buscarPorNombre(String hex){ return (ColorPersistible) this.dao.buscarPorNombre(hex); }

}
