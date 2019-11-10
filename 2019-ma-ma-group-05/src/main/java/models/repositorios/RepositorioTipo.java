package models.repositorios;

import models.entities.Categoria;
import models.entities.Tela;
import models.entities.Tipo;
import models.repositorios.DAOs.DAO;
import models.repositorios.DAOs.DAOTipo;

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

    @Override
    public void iniciarBase() {
        Tipo collar = new Tipo("Collar",0,0);
        this.setCategoria(collar,"Accesorio");
        this.setTela(collar,"Cuero"); this.setTela(collar, "Algodon");

        Tipo camisa = new Tipo("Camisa",1,12);
        this.setCategoria(camisa,"Superior");
        this.setTela(camisa,"Nylon"); this.setTela(camisa, "Algodon");
        this.setTela(camisa, "Seda"); this.setTela(camisa, "Poliester");

        Tipo pantalon = new Tipo("Pantalon",0,30);
        this.setCategoria(pantalon,"Inferior");
        this.setTela(pantalon,"Nylon"); this.setTela(pantalon, "Algodon");
        this.setTela(pantalon, "Seda"); this.setTela(pantalon, "Poliester");

        Tipo remera = new Tipo("Remera",0,10);
        this.setCategoria(remera,"Superior");
        this.setTela(remera,"Nylon"); this.setTela(remera, "Algodon");
        this.setTela(remera, "Seda"); this.setTela(remera, "Poliester");

        Tipo ojotas = new Tipo("Ojotas",0,1);
        this.setCategoria(ojotas,"Calzado");
        this.setTela(ojotas,"Cuero"); this.setTela(ojotas, "Algodon");

        Tipo reloj = new Tipo("Reloj",0,0);
        this.setCategoria(reloj,"Accesorio");
        this.setTela(reloj,"Cuero"); this.setTela(reloj, "Algodon");

        Tipo zapatillas = new Tipo("Zapatillas",0,10);
        this.setCategoria(zapatillas,"Calzado");
        this.setTela(zapatillas,"Cuero"); this.setTela(zapatillas, "Algodon");

        Tipo sweater = new Tipo("Sweater",2,12);
        this.setCategoria(sweater,"Superior");
        this.setTela(sweater,"Nylon"); this.setTela(sweater, "Algodon");
        this.setTela(sweater, "Seda"); this.setTela(sweater, "Poliester");

        Tipo shorts = new Tipo("Shorts",0,15);
        this.setCategoria(shorts,"Inferior");
        this.setTela(shorts,"Nylon"); this.setTela(shorts, "Algodon");
        this.setTela(shorts, "Seda"); this.setTela(shorts, "Poliester");

        Tipo musculosa = new Tipo("Camisa",0,8);
        this.setCategoria(musculosa,"Superior");
        this.setTela(musculosa,"Nylon"); this.setTela(musculosa, "Algodon");
        this.setTela(musculosa, "Seda"); this.setTela(musculosa, "Poliester");

        Tipo campera = new Tipo("Campera",3,25);
        this.setCategoria(campera,"Superior");
        this.setTela(campera,"Nylon"); this.setTela(campera, "Algodon");
        this.setTela(campera, "Seda"); this.setTela(campera, "Poliester");

        this.agregar(collar);
        this.agregar(camisa);
        this.agregar(campera);
        this.agregar(musculosa);
        this.agregar(ojotas);
        this.agregar(pantalon);
        this.agregar(reloj);
        this.agregar(remera);
        this.agregar(shorts);
        this.agregar(sweater);
        this.agregar(zapatillas);
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
            dao.agregar(tipo);
        }
    }
}