package entities.Suscripciones;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Guardarropa;
import entities.Prenda;
import entities.Suscripcion;
import entities.Usuario;

@Entity
@DiscriminatorValue("free")
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
