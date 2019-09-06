package domain.Suscripciones;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import domain.ConfigReader;
import domain.Guardarropa;
import domain.Prenda;
import domain.Suscripcion;
import domain.Usuario;
import domain.Excepciones.LimiteDePrendasAlcanzadoException;

public class Free implements Suscripcion {
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
