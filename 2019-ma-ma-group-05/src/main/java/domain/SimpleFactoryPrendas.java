package domain;

import domain.Tipos.*;
import domain.Tipos.Short;
import services.EmailSender;

public class SimpleFactoryPrendas {
    private static SimpleFactoryPrendas singleInstance = null;

	public static SimpleFactoryPrendas getInstance(){
		if(singleInstance == null){
			singleInstance = new SimpleFactoryPrendas();
		}
		return singleInstance;
	}
	
	public Prenda crearPrenda(String tipo) {
		tipo = tipo.toLowerCase();
		if(tipo == "remera") {
			return new Prenda(Remera.getInstance());
		}
		else if(tipo == "camisa") {
			return new Prenda(Camisa.getInstance());
		}
		else if(tipo == "musculosa") {
			return new Prenda(Musculosa.getInstance());
		}
		else if(tipo == "camisa") {
			return new Prenda(Camisa.getInstance());
		}
		else if(tipo == "campera") {
			return new Prenda(Campera.getInstance());
		}
		else if(tipo == "antiparras") {
			return new Prenda(Antiparras.getInstance());
		}
		else if(tipo == "ojotas") {
			return new Prenda(Ojotas.getInstance());
		}
		else if(tipo == "pantalon") {
			return new Prenda(Pantalon.getInstance());
		}
		else if(tipo == "reloj") {
			return new Prenda(Reloj.getInstance());
		}
		else if(tipo == "short") {
			return new Prenda(Short.getInstance());
		}
		else if(tipo == "sweater") {
			return new Prenda(Sweater.getInstance());
		}
		else if(tipo == "zapatillas") {
			return new Prenda(Zapatillas.getInstance());
		}
	}
}
