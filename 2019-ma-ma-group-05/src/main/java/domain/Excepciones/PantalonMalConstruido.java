package domain.Excepciones;

import domain.TiposDePrenda.Pantalon;

public class PantalonMalConstruido extends Exception{
	private String msj="Pantalon mal construido. NO crees accesorios con los siguientes materiales: "
			+ Pantalon.getTelasInconsistentes().toString();
	public PantalonMalConstruido(){
		System.out.println(this.msj);
	}
}
