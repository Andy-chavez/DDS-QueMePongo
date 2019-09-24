package db;

import entities.Suscripcion;
import entities.Excepciones.HidratarObjetosException;
import entities.Suscripciones.Free;
import entities.Suscripciones.Premium;


public class SimpleFactoryDevolucionDeSuscripciones {
	private static SimpleFactoryDevolucionDeSuscripciones singleInstance = null;

	public static SimpleFactoryDevolucionDeSuscripciones getInstance(){
		if(singleInstance == null){
			singleInstance = new SimpleFactoryDevolucionDeSuscripciones();
		}
		return singleInstance;
	}
	
	public static Suscripcion hidratarSuscripcion(String tipo){
		tipo = tipo.toLowerCase();
		if(tipo == "free") {
			return new Free();
		}
		else if(tipo == "premium") {
			return new Premium();
		}
		throw new HidratarObjetosException("Error desconocido en la obtención de datos de la Base");
	}
}
