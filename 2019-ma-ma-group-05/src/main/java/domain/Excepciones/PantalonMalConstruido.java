package domain.Excepciones;

public class PantalonMalConstruido extends Exception{
	private String msj="Accesorio mal construido. NO crees accesorios con los siguientes materiales:";
	public PantalonMalConstruido() {
		System.out.println(this.msj);
	}

}
