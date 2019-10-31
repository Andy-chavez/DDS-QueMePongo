package models.repositorios;

import models.entities.Categoria;
import models.repositorios.DAOs.DAOCategoria;

import java.util.List;

public class RepositorioCategoria extends Repositorio{
    private static RepositorioCategoria instance;

    public RepositorioCategoria() {
        this.setDao(DAOCategoria.getInstance());
    }

    public static RepositorioCategoria getInstance() {
        if(instance == null){
            instance = new RepositorioCategoria();
        }
        return instance;
    }
    @Override
    public void agregar(Object unObjeto){
        Categoria categ = (Categoria)unObjeto;
        if(this.dao.buscarPorNombre(categ.getNombre())== null){
            dao.agregar(categ);
        }
    }
    public List<Categoria> buscarTodos(){ return (List<Categoria>) (List<?>) this.dao.buscarTodos(); }

    public Categoria buscarPorId(int id){ return (Categoria) this.dao.buscarPorId(id);}

    public Categoria buscarPorNombre(String nombre){ return (Categoria) this.dao.buscarPorNombre(nombre); }
}
