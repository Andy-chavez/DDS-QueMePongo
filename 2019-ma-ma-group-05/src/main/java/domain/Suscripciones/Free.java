package domain.Suscripciones;

import domain.Guardarropa;
import domain.Prenda;
import domain.Suscripcion;
import domain.Usuario;

public class Free implements Suscripcion {
	private int limitePrendas =250; //dps tengo que agregar lo de leer de un archivo
	
	public void cambiarSuscripcion(Usuario usuario,Suscripcion unaSuscripcion) {
		usuario.setSuscripcion(unaSuscripcion);
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda) {
		//TODO limite por archivo y cantidad de prendas
	}
}
