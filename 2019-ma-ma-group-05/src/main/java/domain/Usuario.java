package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Guardarropa;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private String nombre;
	private Suscripcion suscripcion;
	
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this.nombre=unNombre;
		this.guardarropas=new ArrayList<Guardarropa>();
		this.agregarGuardarropa(guardarropa);
	}
	
	public void setSuscripcion(Suscripcion unaSuscripcion) {
		this.suscripcion = unaSuscripcion;
	}
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){
		this.nombre=unNombre;
	}
	public Guardarropa getGuardarropa(String unNombre){
		return this.getGuardarropas().stream().filter(g -> g.getNombre().toLowerCase()==unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	
	public List<Guardarropa> getGuardarropas(){
		return this.guardarropas;
	}
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		this.suscripcion.agregarPrenda(armario,prenda);
		
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa){
		return guardarropa.obtenerSugerencia();
	}
	
}
