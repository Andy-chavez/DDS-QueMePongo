package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import domain.Guardarropa;
import domain.Suscripciones.Free;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private String nombre;
	private Suscripcion suscripcion;
	private List<Evento> eventos;
	private String celular;
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String nuevoNumero) {
		celular = nuevoNumero;
	}
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion=new Free();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this.nombre=unNombre;
		this.guardarropas=new ArrayList<Guardarropa>();
		this.agregarGuardarropa(guardarropa);
		this.suscripcion=new Free();
	}
	
	public void setSuscripcion(Suscripcion unaSuscripcion) {this.suscripcion = unaSuscripcion;}
	public Suscripcion getSuscripcion(){return this.suscripcion;}
	
	public String getNombre(){return this.nombre;}
	public void setNombre(String unNombre){this.nombre=unNombre;}
	
	public Guardarropa getGuardarropa(String unNombre){
		return this.getGuardarropas().stream().filter(g -> g.getNombre().toLowerCase()==unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	public List<Guardarropa> getGuardarropas(){return this.guardarropas;}
	
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		this.suscripcion.agregarPrenda(armario,prenda,this);
		
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa){
		return guardarropa.obtenerSugerencia(24); // TODO: conseguir temperatura y mandarlo como parametro
	}
	
	public void crearEvento(String nombre, String lugar, int anio, int mes, int dia) {
		Evento evento = new Evento();
		evento.setNombre(nombre);
		evento.setLugar(lugar);
		evento.setFecha(anio, mes, dia);
		eventos.add(evento);
	}
	
	public Evento getEvento(String unNombre){
		return this.eventos.stream().filter(e -> e.getNombre().toLowerCase() == unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	
}
