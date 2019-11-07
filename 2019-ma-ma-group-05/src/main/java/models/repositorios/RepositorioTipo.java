package models.repositorios;

import models.entities.Categoria;
import models.entities.Tela;
import models.entities.Tipo;
import models.repositorios.DAOs.DAO;
import models.repositorios.DAOs.DAOCategoria;
import models.repositorios.DAOs.DAOTipo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTipo extends Repositorio{
    private static RepositorioTipo instance;

    public static RepositorioTipo getInstance() {
        if(instance == null){  instance = new RepositorioTipo(DAOTipo.getInstance());        }
        return instance;
    }

    public RepositorioTipo(DAO dao) {
        this.setDao(dao);
    }

    public List<Tipo> buscarTodos(){ return (List<Tipo>) (List<?>) this.dao.buscarTodos(); }

    public Tipo buscarPorId(int id){ return (Tipo) this.dao.buscarPorId(id);}

    public Tipo buscarPorNombre(String nombre){ return (Tipo) this.dao.buscarPorNombre(nombre); }

    private void hidratarTelaEnCasoDeExistir(Tela tela, List<Tela> telasParaTipo){
        if(RepositorioTela.getInstance().buscarPorNombre(tela.getNombre())!= null ){
            telasParaTipo.add(RepositorioTela.getInstance().buscarPorNombre(tela.getNombre()));
        }
        else{
            telasParaTipo.add(tela);
        }
    }

    private void verificarListaDeTelas(Tipo tipo){
        tipo.getTelasPosibles().forEach(tela -> {RepositorioTela.getInstance().agregar(tela);});
    }
    public Tipo crearNuevoTipo(String nombre){
        Tipo tipo = this.buscarPorNombre(nombre);
        if(tipo != null)
            return tipo;
        else
            return new Tipo(nombre);
    }

    public void setCategoria(Tipo unTipo, String categoria){
        Categoria nuevaCategoria = RepositorioCategoria.getInstance().buscarPorNombre(categoria);
        if(nuevaCategoria != null)
            unTipo.setCategoria(nuevaCategoria); //categoria se hidrata y se setea bien
        else
            unTipo.setCategoria(new Categoria(categoria));
    }
    public void setTela(Tipo unTipo, String tela){
        Tela nuevaTela = RepositorioTela.getInstance().buscarPorNombre(tela);
        if(nuevaTela != null)
            unTipo.getTelasPosibles().add(nuevaTela);
        else
            unTipo.getTelasPosibles().add(new Tela(tela));
    }
    public void agregar(Object unObjeto){
        Tipo tipo = (Tipo)unObjeto;
        if(this.dao.buscarPorNombre(tipo.getNombre())== null){
            this.verificarListaDeTelas(tipo);
            dao.agregar(tipo); //aca tiene problemas al persistir una FK a una fila de categoria existente
        }
    }
}