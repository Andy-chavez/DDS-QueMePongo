package domain.Excepciones;

import domain.Prenda;
import domain.TiposDePrenda.Pantalon;

public class PrendaMalConstruida extends Exception{
	public PrendaMalConstruida(Prenda prenda){
		this.msj(prenda);
	}
	public void msj(Prenda prenda){
		System.out.println("Prenda mal construido. NO crees "+ prenda.getClass().getSimpleName().toString()+ 
				" con los siguientes materiales: "
				+ prenda.getTelasInconsistentes().toString()); 
	}
}
