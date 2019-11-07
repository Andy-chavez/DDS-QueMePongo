package models.domain;

import models.entities.Categorias.*;
import models.domain.Excepciones.CrearPrendaException;
import models.entities.Prenda;
import models.entities.Tela;
import models.entities.Tipo;
import models.repositorios.RepositorioTipo;

import java.util.ArrayList;
import java.util.List;

public class SimpleFactoryPrendas {
    private static SimpleFactoryPrendas singleInstance = null;

	public static SimpleFactoryPrendas getInstance(){
		if(singleInstance == null){
			singleInstance = new SimpleFactoryPrendas();
		}
		return singleInstance;
	}
	
	public static Prenda crearPrenda(String tipo){
		List<Tela> cueroYAlgodon = new ArrayList<>();
		List<Tela> algNylPolYSed = new ArrayList<>();
		cueroYAlgodon.add(new Tela("cuero"));
		cueroYAlgodon.add(new Tela("algodon"));
		algNylPolYSed.add(new Tela("algodon"));
		algNylPolYSed.add(new Tela("nylon"));
		algNylPolYSed.add(new Tela("seda"));
		algNylPolYSed.add(new Tela("poliester"));
		tipo = tipo.toLowerCase();
		if(tipo == "remera") {
			Tipo tipoRemera = RepositorioTipo.getInstance().crearNuevoTipo("Remera");
			RepositorioTipo.getInstance().setCategoria(tipoRemera,"Superior");
			tipoRemera.setCapa(0);
			tipoRemera.setNivelAbrigo(10);
			RepositorioTipo.getInstance().setTela(tipoRemera,"algodon");
			RepositorioTipo.getInstance().setTela(tipoRemera,"poliester");
			RepositorioTipo.getInstance().setTela(tipoRemera,"seda");
			return new Prenda(tipoRemera);
		}
		else if(tipo == "musculosa") {
			Tipo tipoMusculosa= RepositorioTipo.getInstance().crearNuevoTipo("Musculosa");
			RepositorioTipo.getInstance().setCategoria(tipoMusculosa,"Superior");
			tipoMusculosa.setCapa(0);
			tipoMusculosa.setNivelAbrigo(8);
			RepositorioTipo.getInstance().setTela(tipoMusculosa,"algodon");
			RepositorioTipo.getInstance().setTela(tipoMusculosa,"poliester");
			RepositorioTipo.getInstance().setTela(tipoMusculosa,"seda");
			return new Prenda(tipoMusculosa);
		}
		else if(tipo == "camisa") {
			Tipo tipoCamisa= RepositorioTipo.getInstance().crearNuevoTipo("Camisa");
			RepositorioTipo.getInstance().setCategoria(tipoCamisa,"Superior");
			tipoCamisa.setCapa(1);
			tipoCamisa.setNivelAbrigo(12);
			RepositorioTipo.getInstance().setTela(tipoCamisa,"algodon");
			RepositorioTipo.getInstance().setTela(tipoCamisa,"poliester");
			RepositorioTipo.getInstance().setTela(tipoCamisa,"seda");
			RepositorioTipo.getInstance().setTela(tipoCamisa,"nylon");
			return new Prenda(tipoCamisa);
		}
		else if(tipo == "campera") {
			Tipo tipoCampera= RepositorioTipo.getInstance().crearNuevoTipo("Campera");
			RepositorioTipo.getInstance().setCategoria(tipoCampera,"Superior");
			tipoCampera.setCapa(3);
			tipoCampera.setNivelAbrigo(25);
			RepositorioTipo.getInstance().setTela(tipoCampera,"algodon");
			RepositorioTipo.getInstance().setTela(tipoCampera,"poliester");
			RepositorioTipo.getInstance().setTela(tipoCampera,"seda");
			return new Prenda(tipoCampera);
		}
		else if(tipo == "collar") {
			Tipo tipoCollar = RepositorioTipo.getInstance().crearNuevoTipo("Collar");
			RepositorioTipo.getInstance().setCategoria(tipoCollar,"Accesorio");
			tipoCollar.setCapa(0);
			tipoCollar.setNivelAbrigo(0);
			RepositorioTipo.getInstance().setTela(tipoCollar,"algodon");
			RepositorioTipo.getInstance().setTela(tipoCollar,"cuero");
			return new Prenda(tipoCollar);
		}
		else if(tipo == "ojotas") {
			Tipo tipoOjotas = RepositorioTipo.getInstance().crearNuevoTipo("Ojotas");
			RepositorioTipo.getInstance().setCategoria(tipoOjotas,"Calzado");
			tipoOjotas.setCapa(0);
			tipoOjotas.setNivelAbrigo(1);
			RepositorioTipo.getInstance().setTela(tipoOjotas,"algodon");
			RepositorioTipo.getInstance().setTela(tipoOjotas,"cuero");
			return new Prenda(tipoOjotas);
		}
		else if(tipo == "pantalon") {
			Tipo tipoPantalon= RepositorioTipo.getInstance().crearNuevoTipo("Pantalon");
			RepositorioTipo.getInstance().setCategoria(tipoPantalon,"Inferior");
			tipoPantalon.setCapa(0);
			tipoPantalon.setNivelAbrigo(30);
			RepositorioTipo.getInstance().setTela(tipoPantalon,"algodon");
			RepositorioTipo.getInstance().setTela(tipoPantalon,"poliester");
			RepositorioTipo.getInstance().setTela(tipoPantalon,"seda");
			RepositorioTipo.getInstance().setTela(tipoPantalon,"nylon");
			return new Prenda(tipoPantalon);
		}
		else if(tipo == "reloj") {
			Tipo tipoAccesorio= RepositorioTipo.getInstance().crearNuevoTipo("Accesorio");
			RepositorioTipo.getInstance().setCategoria(tipoAccesorio,"Superior");
			tipoAccesorio.setCapa(0);
			tipoAccesorio.setNivelAbrigo(0);
			RepositorioTipo.getInstance().setTela(tipoAccesorio,"algodon");
			RepositorioTipo.getInstance().setTela(tipoAccesorio,"cuero");
			RepositorioTipo.getInstance().setTela(tipoAccesorio,"seda");
			return new Prenda(tipoAccesorio);
		}
		else if(tipo == "shorts") {
			Tipo tipoShorts= RepositorioTipo.getInstance().crearNuevoTipo("Shorts");
			RepositorioTipo.getInstance().setCategoria(tipoShorts,"Inferior");
			tipoShorts.setCapa(0);
			tipoShorts.setNivelAbrigo(15);
			RepositorioTipo.getInstance().setTela(tipoShorts,"algodon");
			RepositorioTipo.getInstance().setTela(tipoShorts,"poliester");
			RepositorioTipo.getInstance().setTela(tipoShorts,"seda");
			return new Prenda(tipoShorts);
		}
		else if(tipo == "sweater") {
			Tipo tipoSweater = RepositorioTipo.getInstance().crearNuevoTipo("Sweater");
			RepositorioTipo.getInstance().setCategoria(tipoSweater,"Superior");
			tipoSweater.setCapa(2);
			tipoSweater.setNivelAbrigo(12);
			RepositorioTipo.getInstance().setTela(tipoSweater,"algodon");
			RepositorioTipo.getInstance().setTela(tipoSweater,"poliester");
			RepositorioTipo.getInstance().setTela(tipoSweater,"seda");
			return new Prenda(tipoSweater);
		}
		else if(tipo == "zapatillas") {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Zapatillas");
			RepositorioTipo.getInstance().setCategoria(tipoZapatillas,"Calzado");
			tipoZapatillas.setCapa(0);
			tipoZapatillas.setNivelAbrigo(10);
			RepositorioTipo.getInstance().setTela(tipoZapatillas,"algodon");
			RepositorioTipo.getInstance().setTela(tipoZapatillas,"cuero");
			return new Prenda(tipoZapatillas);
		}

		throw new CrearPrendaException("Tipo de Prenda inexistente");
	}
}
