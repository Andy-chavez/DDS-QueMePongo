package models.repositorios;

import models.entities.*;
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

    public void setColorPrimario(Prenda unaPrenda, String hexColor){
        ColorPersistible nuevoColor = RepositorioColor.getInstance().buscarPorNombre(hexColor);
        if(nuevoColor != null)
            unaPrenda.setColorPrimario(nuevoColor);
        else
            unaPrenda.setColorPrimario(new ColorPersistible(hexColor));
    }
    public void setColorSecundario(Prenda unaPrenda, String hexColor){
        ColorPersistible nuevoColor = RepositorioColor.getInstance().buscarPorNombre(hexColor);
        if(nuevoColor != null)
            unaPrenda.setColorSecundario(nuevoColor);
        else
            unaPrenda.setColorSecundario(new ColorPersistible(hexColor));
    }
    public void setTela(Prenda unaPrenda, String tela){
        Tela nuevaTela = RepositorioTela.getInstance().buscarPorNombre(tela);
        if(nuevaTela != null)
            unaPrenda.setTela(nuevaTela);
        else
            unaPrenda.setTela((new Tela(tela)));
    }

    public void setTipo(Prenda unaPrenda, String tipo){
        Tipo nuevoTipo = RepositorioTipo.getInstance().buscarPorNombre(tipo);
        if(nuevoTipo != null)
            unaPrenda.setTipo(nuevoTipo);
        else
            unaPrenda.setTipo((new Tipo(tipo)));
    }
    @Override
    public void agregar(Object unObjeto){
        Prenda prenda = (Prenda)unObjeto;
        this.dao.agregar(prenda);

    }
}
