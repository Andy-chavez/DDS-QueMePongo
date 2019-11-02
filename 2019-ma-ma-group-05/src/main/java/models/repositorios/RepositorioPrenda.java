package models.repositorios;

import models.entities.Prenda;
import models.repositorios.DAOs.DAOCategoria;
import models.repositorios.DAOs.DAOPrenda;
import models.repositorios.DAOs.DAOTipo;

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

    public List<Prenda> buscarTodos(int id){ return (List<Prenda>) (List<?>) this.dao.buscarTodos(id); }

    public Prenda buscarPorId(int id){ return (Prenda) this.dao.buscarPorId(id);}

    public void verificarAtributosPersistidosDePrenda(Prenda prenda){
        if(RepositorioTipo.getInstance().buscarPorNombre(prenda.getTipo().getNombre())!= null ){
            prenda.setTipo(RepositorioTipo.getInstance().buscarPorNombre(prenda.getTipo().getNombre()));
        }
        if(RepositorioTela.getInstance().buscarPorNombre(prenda.getTela().getNombre())!= null ){
            prenda.setTela(RepositorioTela.getInstance().buscarPorNombre(prenda.getTela().getNombre()));
        }
        if(RepositorioColor.getInstance().buscarPorNombre(prenda.getColorPrimario().getHex())!= null ){
            prenda.setColorPrimario(RepositorioColor.getInstance().buscarPorNombre(prenda.getColorPrimario().getHex()));
        }
        if(prenda.getColorSecundario() != null){
            if(RepositorioColor.getInstance().buscarPorNombre(prenda.getColorSecundario().getHex())!= null ){
                prenda.setColorSecundario(RepositorioColor.getInstance().buscarPorNombre(prenda.getColorSecundario().getHex()));
            }
        }
    }
    @Override
    public void agregar(Object unObjeto){
        Prenda prenda = (Prenda)unObjeto;
        this.verificarAtributosPersistidosDePrenda(prenda);
        this.dao.agregar(prenda);

    }
}
