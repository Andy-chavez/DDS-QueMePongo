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
        // -------------------- SUPERIOR ----------------------
        Tipo remeraCuelloRedondoMangaCorta = new Tipo("Remera cuello redondo manga corta",0,5);
        this.setCategoria(remeraCuelloRedondoMangaCorta,"Superior");
        this.setTela(remeraCuelloRedondoMangaCorta,"Seda");
        this.setTela(remeraCuelloRedondoMangaCorta, "Algodon");
        this.setTela(remeraCuelloRedondoMangaCorta,"Poliester");
        this.setTela(remeraCuelloRedondoMangaCorta,"Lycra");

        Tipo remeraCuelloRedondoMangaLarga = new Tipo("Remera cuello redondo manga larga",0,8);
        this.setCategoria(remeraCuelloRedondoMangaLarga,"Superior");
        this.setTela(remeraCuelloRedondoMangaLarga,"Seda");
        this.setTela(remeraCuelloRedondoMangaLarga, "Algodon");
        this.setTela(remeraCuelloRedondoMangaLarga,"Poliester");
        this.setTela(remeraCuelloRedondoMangaLarga,"Lycra");

        Tipo remeraEscoteVMangaCorta = new Tipo("Remera escote V manga corta",0,5);
        this.setCategoria(remeraEscoteVMangaCorta,"Superior");
        this.setTela(remeraEscoteVMangaCorta,"Seda");
        this.setTela(remeraEscoteVMangaCorta, "Algodon");
        this.setTela(remeraEscoteVMangaCorta,"Poliester");
        this.setTela(remeraEscoteVMangaCorta,"Lycra");

        Tipo remeraEscoteVMangaLarga = new Tipo("Remera escote V manga larga",0,8);
        this.setCategoria(remeraEscoteVMangaLarga,"Superior");
        this.setTela(remeraEscoteVMangaLarga,"Seda");
        this.setTela(remeraEscoteVMangaLarga, "Algodon");
        this.setTela(remeraEscoteVMangaLarga,"Poliester");
        this.setTela(remeraEscoteVMangaLarga,"Lycra");

        Tipo sueter = new Tipo("Sueter",2,15);
        this.setCategoria(sueter,"Superior");
        this.setTela(sueter,"Seda");
        this.setTela(sueter, "Algodon");
        this.setTela(sueter,"Poliester");

        Tipo campera = new Tipo("Campera",2,13);
        this.setCategoria(campera,"Superior");
        this.setTela(campera,"Seda");
        this.setTela(campera, "Algodon");
        this.setTela(campera,"Poliester");
        this.setTela(campera,"Cuero");
        this.setTela(campera,"Nylon");

        Tipo buzo = new Tipo("Buzo",2,13);
        this.setCategoria(buzo,"Superior");
        this.setTela(buzo,"Lycra");
        this.setTela(buzo, "Algodon");
        this.setTela(buzo,"Poliester");
        this.setTela(buzo,"Nylon");

        Tipo musculosa = new Tipo("Musculosa",0,3);
        this.setCategoria(musculosa,"Superior");
        this.setTela(musculosa,"Lycra");
        this.setTela(musculosa, "Algodon");

        // -------------------- INFERIOR ----------------------
        Tipo pantalónLargo = new Tipo("Pantalón largo",0,8);
        this.setCategoria(pantalónLargo,"Inferior");
        this.setTela(pantalónLargo,"Seda");
        this.setTela(pantalónLargo, "Algodon");
        this.setTela(pantalónLargo,"Poliester");
        this.setTela(pantalónLargo,"Jean");
        this.setTela(pantalónLargo,"Nylon");

        Tipo pantalónCorto = new Tipo("Pantalón corto",0,3);
        this.setCategoria(pantalónCorto,"Inferior");
        this.setTela(pantalónCorto,"Seda");
        this.setTela(pantalónCorto, "Algodon");
        this.setTela(pantalónCorto,"Poliester");
        this.setTela(pantalónCorto,"Jean");
        this.setTela(pantalónCorto,"Nylon");

        Tipo bermuda = new Tipo("Bermuda",0,3);
        this.setCategoria(bermuda,"Inferior");
        this.setTela(bermuda,"Seda");
        this.setTela(bermuda, "Algodon");
        this.setTela(bermuda,"Poliester");
        this.setTela(bermuda,"Jean");
        this.setTela(bermuda,"Nylon");

        Tipo pollera = new Tipo("Pollera",0,3);
        this.setCategoria(pollera,"Inferior");
        this.setTela(pollera,"Seda");
        this.setTela(pollera, "Algodon");
        this.setTela(pollera,"Poliester");
        this.setTela(pollera,"Jean");
        this.setTela(pollera,"Nylon");

        Tipo calza = new Tipo("Calza",0,5);
        this.setCategoria(calza,"Inferior");
        this.setTela(calza,"Lycra");
        this.setTela(calza, "Algodon");
        this.setTela(calza,"Poliester");
        this.setTela(calza,"Nylon");
        // -------------------- CALZADO ----------------------
        Tipo zapatos = new Tipo("Zapatos",0,1);
        this.setCategoria(zapatos,"Calzado");
        this.setTela(zapatos,"Cuero");

        Tipo zapatillas = new Tipo("Zapatillas",0,1);
        this.setCategoria(zapatillas,"Calzado");
        this.setTela(zapatillas,"Cuero");
        this.setTela(zapatillas,"Nylon");

        Tipo sandalias = new Tipo("Sandalias",0,1);
        this.setCategoria(sandalias,"Calzado");
        this.setTela(sandalias,"Cuero");
        this.setTela(sandalias,"Nylon");
        // -------------------- ACCESORIO ----------------------

        // -------------------- PERSISTENCIA ----------------------
        this.agregar(remeraCuelloRedondoMangaCorta);
        this.agregar(remeraCuelloRedondoMangaLarga);
        this.agregar(remeraEscoteVMangaCorta);
        this.agregar(remeraEscoteVMangaLarga);
        this.agregar(sueter);
        this.agregar(campera);
        this.agregar(buzo);
        this.agregar(musculosa);

        this.agregar(pantalónCorto);
        this.agregar(pantalónLargo);
        this.agregar(bermuda);
        this.agregar(pollera);
        this.agregar(calza);

        this.agregar(zapatos);
        this.agregar(sandalias);
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