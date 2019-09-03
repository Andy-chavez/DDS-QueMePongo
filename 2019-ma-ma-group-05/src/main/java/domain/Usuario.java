package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import domain.Guardarropa;
import domain.Suscripciones.Free;
import dtoClases.EventoDto;

import java.time.Instant;
import java.time.LocalDate;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private String nombre;
	private Suscripcion suscripcion;
	private List<Evento> eventos;
	private String celular;
	private String mail;
	private SensibilidadFrio sensibilidadFrio;
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	private GestorSugerencia gestorSugerencia;
	
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion=new Free();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this(unNombre);
		this.agregarGuardarropa(guardarropa);
	}
	public HashMap<Usuario,Guardarropa> getGuardarropasCompartidos(){
		return this.guardarropasCompartidos;
	}
	public void compartirGuardarropa(Usuario otroUsuario,Guardarropa g){
		this.guardarropasCompartidos.put(otroUsuario, g);
		otroUsuario.agregarGuardarropa(g);
	}
	public void sacarCompartimientoDeGuardarropaAUnUsuario(Usuario otroUsuario,Guardarropa g){
		otroUsuario.getGuardarropas().remove(g);
		this.guardarropasCompartidos.remove(otroUsuario, g);
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String nuevoMail) {
		mail = nuevoMail;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String nuevoNumero) {
		celular = nuevoNumero;
	}
	public void cambiarAPremium(){
		this.suscripcion.cambiarAPremium(this);
	}
	public void cambiarAFree(){
		this.suscripcion.cambiarAFree(this);
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
	public List<Prenda> getPrendasDelguardarropa(String nombre){
		Guardarropa g =  this.getGuardarropa(nombre);
		return this.suscripcion.getPrendasDelGuardarropa(g);
	}
	
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		this.suscripcion.agregarPrenda(armario,prenda);
		
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa){
		return gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, sensibilidadFrio);
	}
	
	public void crearEvento(EventoDto unEvento) {
		Evento evento = new Evento(unEvento);
		eventos.add(evento);
	}
	
	public Evento getEvento(String unNombre){
		return this.eventos.stream().filter(e -> e.getNombre().toLowerCase() == unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	
	public SensibilidadFrio getSensibilidadFrio(){
		return this.sensibilidadFrio;
	}
	public void aumentarSensibilidadSuperior(){
		this.sensibilidadFrio.aumentarSuperior();
	}
	public void aumentarSensibilidadInferior(){
		this.sensibilidadFrio.aumentarInferior();
	}
	public void disminuirSensibilidadSuperior(){
		this.sensibilidadFrio.disminuirSuperior();
	}
	public void disminuirSensibilidadInferior(){
		this.sensibilidadFrio.disminuirInferior();
	}
}
