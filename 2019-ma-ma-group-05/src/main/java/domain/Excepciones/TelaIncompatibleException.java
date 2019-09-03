package domain.Excepciones;

public class TelaIncompatibleException extends RuntimeException{
	public TelaIncompatibleException(String mensaje){
		super(mensaje);
	}	
}

