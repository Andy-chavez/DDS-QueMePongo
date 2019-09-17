package domain;

import java.util.List;

public abstract class Suscripcion{
	protected abstract void agregarPrenda(Guardarropa armario,Prenda prenda);
	protected abstract void cambiarAPremium(Usuario u);
	protected abstract void cambiarAFree(Usuario u);
	protected abstract List<Prenda> getPrendasDelGuardarropa(Guardarropa g);
}
