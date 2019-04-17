package domain;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private String nombre;
	
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this.nombre=unNombre;
		this.guardarropas=new ArrayList<Guardarropa>();
		this.agregarGuardarropa(guardarropa);
	}
	
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){
		this.nombre=unNombre;
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		armario.agregarPrenda(prenda);
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa){
		return guardarropa.obtenerSugerencia();
	}
	
}
