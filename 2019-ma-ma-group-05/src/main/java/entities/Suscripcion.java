package entities;

import java.util.List;

public abstract class Suscripcion extends EntidadPersistente {
	protected abstract void agregarPrenda(Guardarropa armario,Prenda prenda);
	protected abstract void cambiarAPremium(Usuario u);
	protected abstract void cambiarAFree(Usuario u);
	protected abstract List<Prenda> getPrendasDelGuardarropa(Guardarropa g);
}
