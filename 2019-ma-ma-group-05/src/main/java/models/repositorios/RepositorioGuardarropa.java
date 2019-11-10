package models.repositorios;

import models.entities.Guardarropa;
import models.entities.Prenda;
import models.repositorios.DAOs.DAOGuardarropa;

import java.util.List;

public class RepositorioGuardarropa extends Repositorio {
    private static RepositorioGuardarropa instance;

    public static RepositorioGuardarropa getInstance() {
        if(instance == null){
            instance = new RepositorioGuardarropa();
        }
        return instance;
    }
    public RepositorioGuardarropa() {
        this.setDao(DAOGuardarropa.getInstance());
    }
    public List<Guardarropa> buscarTodos(){ return (List<Guardarropa>) (List<?>) this.dao.buscarTodos(); }

    public Guardarropa buscarPorId(int id){ return (Guardarropa) this.dao.buscarPorId(id); }

    public Guardarropa buscarPorNombre(String nombre){ return (Guardarropa) this.dao.buscarPorNombre(nombre); }

    public void recorrerPrendas(Guardarropa g){
        if(g.getPrendas()!= null){
            List<Prenda> prendas = g.getPrendas();
            for (Prenda prenda : prendas) {
                RepositorioPrenda.getInstance().agregar(prenda);
            }
        }

    }
    @Override
    public void agregar(Object unObject){
        Guardarropa g = (Guardarropa) unObject;
        this.recorrerPrendas(g);
        dao.agregar(g);
    }
}
