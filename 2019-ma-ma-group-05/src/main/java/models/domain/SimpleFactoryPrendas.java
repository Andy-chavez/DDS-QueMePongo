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
		if(tipo.equals("remera cuello redondo manga corta")) {
			Tipo tipoRemera = RepositorioTipo.getInstance().crearNuevoTipo("Remera cuello redondo manga corta");
			return new Prenda(tipoRemera);
		}
		else if(tipo.equals("remera escote v manga corta")) {
			Tipo tipoMusculosa= RepositorioTipo.getInstance().crearNuevoTipo("Remera escote V manga corta");
			return new Prenda(tipoMusculosa);
		}
		else if(tipo.equals("remera cuello redondo manga larga")) {
			Tipo tipoCamisa= RepositorioTipo.getInstance().crearNuevoTipo("Remera cuello redondo manga larga");
			return new Prenda(tipoCamisa);
		}
		else if(tipo.equals("remera escote v manga larga")) {
			Tipo tipoCampera= RepositorioTipo.getInstance().crearNuevoTipo("Remera escote V manga larga");
			return new Prenda(tipoCampera);
		}
		else if(tipo.equals("sueter")) {
			Tipo tipoCollar = RepositorioTipo.getInstance().crearNuevoTipo("Sueter");
			return new Prenda(tipoCollar);
		}
		else if(tipo.equals("campera")) {
			Tipo tipoOjotas = RepositorioTipo.getInstance().crearNuevoTipo("Campera");
			return new Prenda(tipoOjotas);
		}
		else if(tipo.equals("pantalón largo")) {
			Tipo tipoPantalon= RepositorioTipo.getInstance().crearNuevoTipo("Pantalón largo");
			return new Prenda(tipoPantalon);
		}
		else if(tipo.equals("pantalón corto")) {
			Tipo tipoAccesorio= RepositorioTipo.getInstance().crearNuevoTipo("Pantalón corto");
			return new Prenda(tipoAccesorio);
		}
		else if(tipo.equals("bermuda")) {
			Tipo tipoShorts= RepositorioTipo.getInstance().crearNuevoTipo("Bermuda");
			return new Prenda(tipoShorts);
		}
		else if(tipo.equals("pollera")) {
			Tipo tipoSweater = RepositorioTipo.getInstance().crearNuevoTipo("Pollera");
			return new Prenda(tipoSweater);
		}
		else if(tipo.equals("calza")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Calza");
			return new Prenda(tipoZapatillas);
		}
		else if(tipo.equals("buzo")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Buzo");
			return new Prenda(tipoZapatillas);
		}
		else if(tipo.equals("musculosa")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Musculosa");
			return new Prenda(tipoZapatillas);
		}
		else if(tipo.equals("zapatillas")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Zapatillas");
			return new Prenda(tipoZapatillas);
		}
		else if(tipo.equals("zapatos")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Zapatos");
			return new Prenda(tipoZapatillas);
		}
		else if(tipo.equals("sandalias")) {
			Tipo tipoZapatillas= RepositorioTipo.getInstance().crearNuevoTipo("Sandalias");
			return new Prenda(tipoZapatillas);
		}
		throw new CrearPrendaException("Tipo de Prenda inexistente");
	}
}
