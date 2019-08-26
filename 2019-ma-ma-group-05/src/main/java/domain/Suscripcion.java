package domain;

import java.util.List;

public interface Suscripcion {
	public void agregarPrenda(Guardarropa armario,Prenda prenda);
	public void cambiarAPremium(Usuario u);
	public void cambiarAFree(Usuario u);
	public List<Prenda> getPrendasDelGuardarropa(Guardarropa g);
}
