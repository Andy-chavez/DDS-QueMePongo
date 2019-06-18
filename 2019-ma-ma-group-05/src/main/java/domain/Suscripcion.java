package domain;

import java.util.List;

public interface Suscripcion {
	public void agregarPrenda(Guardarropa armario,Prenda prenda,Usuario usuario);
	public void cambiarSuscripcion(Usuario usuario,Suscripcion unaSuscripcion);
	public List<Prenda> filtrarPrendas(List<Prenda> prendas);
}
