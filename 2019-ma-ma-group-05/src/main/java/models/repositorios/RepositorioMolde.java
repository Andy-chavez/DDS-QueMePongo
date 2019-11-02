package models.repositorios;

import models.entities.MoldeAtuendo;
import models.entities.Tipo;
import models.repositorios.DAOs.DAOMoldeAtuendo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioMolde extends Repositorio {
    private static RepositorioMolde instance;

    public RepositorioMolde() {
        this.setDao(DAOMoldeAtuendo.getInstance());
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

    public MoldeAtuendo buscarPorId(int id){ return (MoldeAtuendo) this.dao.buscarPorId(id); }

    public MoldeAtuendo buscarPorNombre(String nombre){ return (MoldeAtuendo) this.dao.buscarPorNombre(nombre); }

    private void hidratarTipoEnCasoDeExistir(Tipo tipo, List<Tipo> telasParaTipo){
        if(RepositorioTela.getInstance().buscarPorNombre(tipo.getNombre())!= null ){
            telasParaTipo.add(RepositorioTipo.getInstance().buscarPorNombre(tipo.getNombre()));
        }
        else{
            telasParaTipo.add(tipo);
        }
    }

    private void verificarListaDeTipos(MoldeAtuendo molde){
        List<Tipo> tiposNuevos;
        tiposNuevos = new ArrayList<Tipo>();
        molde.getMoldeTipos().forEach(tipo -> {this.hidratarTipoEnCasoDeExistir(tipo,tiposNuevos);});
        molde.getMoldeTipos().clear();
        molde.setMoldeTipos(tiposNuevos);
    }
    @Override
    public void agregar(Object unObjeto){
        MoldeAtuendo molde = (MoldeAtuendo) unObjeto;
        this.verificarListaDeTipos(molde);
    }
}
