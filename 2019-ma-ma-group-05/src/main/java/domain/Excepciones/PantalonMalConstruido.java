package domain.Excepciones;

public class PantalonMalConstruido extends Exception{
	private String msj="Accesorio mal construido. NO crees accesorios con los siguientes materiales: Nylon,Elastina";
	public String msj(){return this.msj;}

}
