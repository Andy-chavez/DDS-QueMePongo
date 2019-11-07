package models.domain;

import models.entities.Categorias.*;
import models.domain.Excepciones.CrearPrendaException;
import models.entities.Prenda;
import models.entities.Tela;
import models.entities.Tipo;

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
			return new Prenda(new Tipo("Remera",new Superior(),algNylPolYSed,0,10));
		}
		else if(tipo == "musculosa") {
			return new Prenda(new Tipo("Musculosa",new Superior(),algNylPolYSed,0,8));
		}
		else if(tipo == "camisa") {
			return new Prenda(new Tipo("Camisa",new Superior(),algNylPolYSed,1,12));
		}
		else if(tipo == "campera") {
			return new Prenda(new Tipo("Campera",new Superior(),algNylPolYSed,3,25));
		}
		else if(tipo == "collar") {
			return new Prenda(new Tipo("Collar",new Accesorio(),cueroYAlgodon,0,0));
		}
		else if(tipo == "ojotas") {
			return new Prenda(new Tipo("Ojotas",new Calzado(),cueroYAlgodon,0,1));
		}
		else if(tipo == "pantalon") {
			return new Prenda(new Tipo("Pantalon",new Inferior(),algNylPolYSed,0,30));
		}
		else if(tipo == "reloj") {
			return new Prenda(new Tipo("Reloj",new Accesorio(),cueroYAlgodon,0,0));
		}
		else if(tipo == "shorts") {
			return new Prenda(new Tipo("Shorts",new Inferior(),algNylPolYSed,0,15));
		}
		else if(tipo == "sweater") {
			return new Prenda(new Tipo("Sweater",new Superior(),algNylPolYSed,2,12));
		}
		else if(tipo == "zapatillas") {
			return new Prenda(new Tipo("Zapatillas",new Calzado(),cueroYAlgodon,0,10));
		}

		throw new CrearPrendaException("Tipo de Prenda inexistente");
	}
}
