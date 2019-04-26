package domain.Excepciones;

import domain.TiposDePrenda.Zapatos;

public class ZapatosMalConstruidos extends Exception{
	private String msj="Calzado mal construido. NO crees calzados con los siguientes materiales: "
			+Zapatos.getTelasInconsistentes();//bleh
	public  ZapatosMalConstruidos() {
		System.out.println(this.msj);
	}{
	}
}
