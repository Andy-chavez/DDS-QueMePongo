package models.domain.Excepciones;

public class LimiteDePrendasAlcanzadoException extends RuntimeException {
	private static String mensaje="Limite de prendas alcanzado";
	public LimiteDePrendasAlcanzadoException(){
		super(mensaje);
		
	}
}
