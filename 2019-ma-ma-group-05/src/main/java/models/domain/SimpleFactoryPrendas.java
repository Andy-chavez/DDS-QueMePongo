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
		tipo = tipo.toLowerCase();
		if(tipo.equals("remera")) {
			Tipo tipoRemera = RepositorioTipo.getInstance().crearNuevoTipo("Remera");
			return new Prenda(tipoRemera);
		}
		else if(tipo.equals("musculosa")) {
			Tipo tipoMusculosa= RepositorioTipo.getInstance().crearNuevoTipo("Musculosa");
			return new Prenda(tipoMusculosa);
		}
		else if(tipo.equals("camisa")) {
			Tipo tipoCamisa= RepositorioTipo.getInstance().crearNuevoTipo("Camisa");
			return new Prenda(tipoCamisa);
		}
		else if(tipo.equals("campera")) {
			Tipo tipoCampera= RepositorioTipo.getInstance().crearNuevoTipo("Campera");
			return new Prenda(tipoCampera);
		}
		else if(tipo.equals("collar")) {
			Tipo tipoCollar = RepositorioTipo.getInstance().crearNuevoTipo("Collar");
			return new Prenda(tipoCollar);
		}
		else if(tipo.equals("ojotas")) {
			Tipo tipoOjotas = RepositorioTipo.getInstance().crearNuevoTipo("Ojotas");
			return new Prenda(tipoOjotas);
		}
		else if(tipo.equals("pantalon")) {
			Tipo tipoPantalon= RepositorioTipo.getInstance().crearNuevoTipo("Pantalon");
			return new Prenda(tipoPantalon);
		}
		else if(tipo.equals("reloj")) {
			Tipo tipoAccesorio= RepositorioTipo.getInstance().crearNuevoTipo("Reloj");
			return new Prenda(tipoAccesorio);
		}
		else if(tipo.equals("shorts")) {
			Tipo tipoShorts= RepositorioTipo.getInstance().crearNuevoTipo("Shorts");
			return new Prenda(tipoShorts);
		}
		else if(tipo.equals("sweater")) {
			Tipo tipoSweater = RepositorioTipo.getInstance().crearNuevoTipo("Sweater");
			return new Prenda(tipoSweater);
		}
		else if(tipo.equals("zapatillas")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Zapatillas");
			return new Prenda(tipoZapatillas);
		}
		throw new CrearPrendaException("Tipo de Prenda inexistente");
	}
}
