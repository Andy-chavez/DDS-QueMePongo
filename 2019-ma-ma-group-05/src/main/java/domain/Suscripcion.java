package domain;


public interface Suscripcion {
	public void agregarPrenda(Guardarropa armario,Prenda prenda,Usuario usuario);
	public void cambiarSuscripcion(Usuario usuario,Suscripcion unaSuscripcion);
}
