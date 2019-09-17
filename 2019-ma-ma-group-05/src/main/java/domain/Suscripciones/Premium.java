package domain.Suscripciones;

import java.util.List;

import domain.Guardarropa;
import domain.Prenda;
import domain.Suscripcion;
import domain.Usuario;

public class Premium extends Suscripcion{
	public void cambiarAFree(Usuario usuario){
		usuario.setSuscripcion(new Free());
	}
	public void cambiarAPremium(Usuario usuario){
		//no sé si lanzar exception o simplemente no hacer nada, me parece too much lanzar una excepción.
		System.out.println("El usuario ya es premium");
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda) {
		armario.agregarPrenda(prenda);
	}
	@Override
	public List<Prenda> getPrendasDelGuardarropa(Guardarropa g) {
		return g.getPrendas();
	}
}
