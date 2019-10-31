package models.repositorios;

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
        if(instance == null){
            instance = new RepositorioTipo(DAOTipo.getInstance());

        }
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
        List<Tela> telasNuevas;
        telasNuevas = new ArrayList<Tela>();
        tipo.getTelasPosibles().forEach(tela -> {this.hidratarTelaEnCasoDeExistir(tela,telasNuevas);});
        tipo.getTelasPosibles().clear();
        tipo.setTelasPosibles(telasNuevas);
    }
    public void agregar(Object unObjeto){
        Tipo tipo = (Tipo)unObjeto;
        if(this.dao.buscarPorNombre(tipo.getNombre())== null){
            this.verificarListaDeTelas(tipo);
            if(RepositorioCategoria.getInstance().buscarPorNombre(tipo.getCategoria().getNombre()) != null) {
                tipo.setCategoria(RepositorioCategoria.getInstance().buscarPorNombre(tipo.getCategoria().getNombre()));
            }
            dao.agregar(tipo);
        }
    }
}