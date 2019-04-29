package domain.Excepciones;

import domain.TiposDePrenda.Remera;

public class RemeraMalConstruida extends Exception{
	private String msj="Remera mal construida. NO crees accesorios con los siguientes materiales: "
			+ Remera.getTelasInconsistentes().toString();
	public RemeraMalConstruida (){
		System.out.println(this.msj);
	}
}
