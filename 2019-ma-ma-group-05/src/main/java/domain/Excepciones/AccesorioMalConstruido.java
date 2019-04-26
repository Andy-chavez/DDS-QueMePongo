package domain.Excepciones;

import domain.TiposDePrenda.Accesorio;

public class AccesorioMalConstruido extends Exception{
	private String msj="Accesorio mal construido. NO crees accesorios con los siguientes materiales: "
			+Accesorio.getTelasInconsistentes().toString();
	
	public AccesorioMalConstruido(){
		System.out.println(this.msj);
	}
}
