package domain.Excepciones;

import domain.TiposDePrenda.Zapatos;

public class ZapatosMalConstruidos extends Exception{
	private String msj="Zapatos mal construidos. NO crees Zapatos con los siguientes materiales: "
			+Zapatos.getTelasInconsistentes();
	public  ZapatosMalConstruidos() {
		System.out.println(this.msj);
	}{
	}
}
