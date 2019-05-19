package domain.Excepciones;

import domain.Prenda;
import domain.TiposDePrenda.Pantalon;

public class PrendaMalConstruida extends Exception{
	public PrendaMalConstruida(Prenda clase){
		this.msj(clase);
	}
	public void msj(Prenda clase){
		System.out.println("Prenda mal construido. NO crees "+ clase.getClass().getSimpleName().toString()+ 
				" con los siguientes materiales: "
				+ clase.getTelasInconsistentes().toString()); 
	}
}
