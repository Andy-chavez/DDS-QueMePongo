package entities.Suscripciones;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import entities.ConfigReader;
import entities.Guardarropa;
import entities.Prenda;
import entities.Suscripcion;
import entities.Usuario;
import entities.Excepciones.LimiteDePrendasAlcanzadoException;

@Entity
@DiscriminatorValue("free")
public class Free extends Suscripcion {
	@Transient
	private int limiteDePrendas;
	public Free(){
		this.inicializarVariablesDesdeConfig();
	}
	private void inicializarVariablesDesdeConfig(){
		ConfigReader cr=new ConfigReader();
		this.limiteDePrendas=cr.getIntValue("configuraciones.properties", "limiteDePrendas");
	}
	public int getLimiteDePrendas(){return this.limiteDePrendas;}
	public void cambiarAFree(Usuario usuario){
		////sé si lanzar exception o simplemente no hacer nada, me parece too much lanzar una excepción.
		System.out.println("El usuario ya es free");
	}
	public void cambiarAPremium(Usuario usuario){
		usuario.setSuscripcion(new Premium());
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
