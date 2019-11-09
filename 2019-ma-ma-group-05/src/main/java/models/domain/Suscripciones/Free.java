package models.domain.Suscripciones;

import java.util.List;

import models.domain.ConfigReader;
import models.entities.Guardarropa;
import models.entities.Prenda;
import models.entities.Suscripcion;
import models.entities.Usuario;
import models.domain.Excepciones.LimiteDePrendasAlcanzadoException;

public class Free extends Suscripcion {
	private int limiteDePrendas;
	private static Free singleInstance = null;
	public static Free getInstance(){
		if(singleInstance == null){
			singleInstance = new Free();
		}
		return singleInstance;
	}
	private Free(){
		this.inicializarVariablesDesdeConfig();
	}
	private void inicializarVariablesDesdeConfig(){
		this.limiteDePrendas=ConfigReader.getIntValue("configuraciones.properties", "limiteDePrendas");
	}
	public int getLimiteDePrendas(){return this.limiteDePrendas;}
	public void cambiarAFree(Usuario usuario){
		////sé si lanzar exception o simplemente no hacer nada, me parece too much lanzar una excepción.
		System.out.println("El usuario ya es free");
	}
	public void cambiarAPremium(Usuario usuario){
		usuario.setSuscripcion(Premium.getInstance());
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda) {
		if(armario.cantidadDePrendas()<this.limiteDePrendas){
			armario.agregarPrenda(prenda);
		}else{
			throw new LimiteDePrendasAlcanzadoException();
		}
	}
	@Override
	public List<Prenda> getPrendasDelGuardarropa(Guardarropa g) {
		return g.getPrendas().subList(0, this.getLimiteDePrendas());
	}
	
}
