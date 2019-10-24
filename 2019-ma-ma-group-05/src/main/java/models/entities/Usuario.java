package models.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import converters.SuscripcionAttributeConverter;
import dtoClases.EventoDto;
import models.entities.Guardarropa;
import models.entities.Suscripciones.Free;

import java.time.Instant;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadPersistente {
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Guardarropa> guardarropas;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "suscripcion")
	private Suscripcion suscripcion;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Evento> eventos;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "mail")
	private String mail;
	
	@OneToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "sensibilidad_frio_id", referencedColumnName = "id")
	private SensibilidadFrio sensibilidadFrio;
	
	@Transient
	private HashMap<Usuario,Guardarropa> guardarropasCompartidos;
	@Transient
	private GestorSugerencia gestorSugerencia;
	@Transient
	private GestorDeOperaciones gestorOperaciones;
	
	public Usuario() {}
	public Usuario(String nombre){
		this.nombre=nombre;
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion= Free.getInstance();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.gestorOperaciones = new  GestorDeOperaciones();
		this.eventos = new ArrayList<Evento>();
	}
	public Usuario(String unNombre,Guardarropa guardarropa){
		this.nombre = unNombre;
		this.guardarropas= new ArrayList<Guardarropa>();
		this.agregarGuardarropa(guardarropa);
		this.suscripcion= Free.getInstance();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.gestorOperaciones = new  GestorDeOperaciones();
	}
	public GestorDeOperaciones getGestorOperaciones(){return this.gestorOperaciones;}
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
	// --- GETTERS Y SETTERS ---
	public String getMail() { return mail; }
	public void setMail(String nuevoMail) {	mail = nuevoMail;	}
	public String getCelular() { return celular; }
	public void setCelular(String nuevoNumero) { celular = nuevoNumero;	}
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
	
	
	public void cambiarAPremium(){
		this.suscripcion.cambiarAPremium(this);
	}
	public void cambiarAFree(){
		this.suscripcion.cambiarAFree(this);
	}
	
	public void agregarPrenda(Guardarropa armario,Prenda prenda){
		this.suscripcion.agregarPrenda(armario,prenda);
		
	}
	public void agregarGuardarropa(Guardarropa guardarropa){
		this.guardarropas.add(guardarropa);
	}
	
	public Atuendo obtenerSugerencia(Guardarropa guardarropa){
		return gestorSugerencia.obtenerSugerencia(Instant.now(), guardarropa, this);
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
