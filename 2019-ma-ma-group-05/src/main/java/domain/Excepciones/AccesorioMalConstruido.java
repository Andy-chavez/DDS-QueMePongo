package domain.Excepciones;

public class AccesorioMalConstruido extends Exception{
	private String msj="Accesorio mal construido. NO crees accesorios con los siguientes materiales: Algodon";
	/*Podría ser así?
	public AccesorioMalConstruido(){
		System.out.println(this.msj());
	}
	*/
	public String msj(){return this.msj;}
}
