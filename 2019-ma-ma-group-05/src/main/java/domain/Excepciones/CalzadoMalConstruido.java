package domain.Excepciones;

public class CalzadoMalConstruido extends Exception{
	private String msj="Calzado mal construido. NO crees calzados con los siguientes materiales: Seda, Polyester";//bleh
	public CalzadoMalConstruido() {
		System.out.println(this.msj);
	}

}