package domain.Excepciones;

import domain.TiposDePrenda.Zapatos;

public class ZapatosMalConstruidos extends Exception{
	private String msj="Zapatos mal construids. NO crees Zapatos con los siguientes materiales: "
			+Zapatos.getTelasInconsistentes();//bleh
	public  ZapatosMalConstruidos() {
		System.out.println(this.msj);
	}{
	}
}
