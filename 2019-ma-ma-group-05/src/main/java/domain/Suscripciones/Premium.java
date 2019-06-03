package domain.Suscripciones;

import domain.Guardarropa;
import domain.Prenda;
import domain.Suscripcion;
import domain.Usuario;

public class Premium implements Suscripcion{
	public void cambiarSuscripcion(Usuario usuario,Suscripcion unaSuscripcion) {
		usuario.setSuscripcion(unaSuscripcion);
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda,Usuario usuario) {
		armario.agregarPrenda(prenda);
	}
}
