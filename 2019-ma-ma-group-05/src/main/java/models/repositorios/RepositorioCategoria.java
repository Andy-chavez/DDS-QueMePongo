package models.repositorios;

import models.entities.Categoria;
import models.entities.Categorias.Accesorio;
import models.entities.Categorias.Calzado;
import models.entities.Categorias.Inferior;
import models.entities.Categorias.Superior;
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
    @Override
    public void iniciarBase(){
        this.agregar(new Superior());
        this.agregar(new Inferior());
        this.agregar(new Calzado());
        this.agregar(new Accesorio());
    }
    public List<Categoria> buscarTodos(){ return (List<Categoria>) (List<?>) this.dao.buscarTodos(); }

    public Categoria buscarPorId(int id){ return (Categoria) this.dao.buscarPorId(id);}

    public Categoria buscarPorNombre(String nombre){ return (Categoria) this.dao.buscarPorNombre(nombre); }
}
