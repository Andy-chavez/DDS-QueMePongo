package models.domain.Excepciones;

public class FallaronTodasLasApisException extends RuntimeException {
	private static String mensaje = "Hay un problema al intentar obtener la temperatura. Intente de nuevo mas tarde";
	public FallaronTodasLasApisException(){
		super(mensaje);
	}
}
