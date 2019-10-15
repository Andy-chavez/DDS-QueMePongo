package models.entities.Suscripciones;

import java.util.List;

import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Suscripcion;
import models.entities.Usuario;

public class Premium extends Suscripcion{
	private static Premium singleInstance = null;
	public static Premium getInstance(){
		if(singleInstance == null){
			singleInstance = new Premium();
		}
		return singleInstance;
	}
	public void cambiarAFree(Usuario usuario){
		usuario.setSuscripcion(Free.getInstance());
	}
	private Premium(){};
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
