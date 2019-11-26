package models.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import dtoClases.EventoDto;
import models.domain.GestorDeOperaciones;
import models.domain.GestorSugerencia;
import models.domain.Suscripciones.Free;

import java.time.Instant;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadPersistente {
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Guardarropa> guardarropas;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "contraseña")
	private String contraseña; //normalmente esto deberia de guardarse hasheado o algo pero como no lo pide no lo agrego

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
	
	public Usuario() {
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion= Free.getInstance();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.gestorOperaciones = new  GestorDeOperaciones();
		this.eventos = new ArrayList<Evento>();
	}
	public Usuario(String nombre) {
		this.setNombre(nombre);
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion= Free.getInstance();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.gestorOperaciones = new  GestorDeOperaciones();
		this.eventos = new ArrayList<Evento>();
	}
	public Usuario(String nombre, String apellido, String usuario, String contraseña, Suscripcion suscripcion){
		this.guardarropas= new ArrayList<Guardarropa>();
		this.suscripcion= Free.getInstance();
		this.sensibilidadFrio = new SensibilidadFrio();
		this.guardarropasCompartidos = new HashMap<Usuario,Guardarropa>();
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.gestorOperaciones = new  GestorDeOperaciones();
		this.eventos = new ArrayList<Evento>();
		this.setNombre(nombre);
		this.setUsuario(usuario);
		this.setApellido(apellido);
		this.setContraseña(contraseña);
		this.setSuscripcion(suscripcion);
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
	public String getApellido(){return this.apellido;}
	public String getUsuario(){return this.usuario;}
	public String getContraseña(){ return this.contraseña; }
	public List<Evento> getEventos(){ return this.eventos; }
	public void setNombre(String unNombre){this.nombre=unNombre;}
	public void setApellido(String apellido){this.apellido=apellido;}
	public void setUsuario(String usuario){this.usuario=usuario;}
	public void setContraseña(String contraseña){this.contraseña=contraseña;}
	public Guardarropa getGuardarropa(String unNombre){
		return this.getGuardarropas().stream().filter(g -> g.getNombre().toLowerCase()==unNombre.toLowerCase())
				.collect(Collectors.toList()).get(0);
	}
	public List<Guardarropa> getGuardarropas(){return this.guardarropas;}
	public List<Prenda> getPrendasDelguardarropa(String nombre){
		Guardarropa g =  this.getGuardarropa(nombre);
		return this.suscripcion.getPrendasDelGuardarropa(g);
	}
	public List<Prenda> getPrendasDelguardarropa(int id){
		Guardarropa g =  this.getGuardarropa(id);
		return this.suscripcion.getPrendasDelGuardarropa(g);
	}
	public Guardarropa getGuardarropa(int id){
		return this.getGuardarropas().stream().filter(g -> g.getId()==id)
				.collect(Collectors.toList()).get(0);
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
