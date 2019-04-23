package domain.Excepciones;

public class RemeraMalConstruida extends Exception{
	private String msj="Accesorio mal construido. NO crees accesorios con los siguientes materiales: Cuero, Polyester";
	public RemeraMalConstruida() {
		System.out.println(this.msj);
	}

}
