package models.entities;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import dtoClases.EventoDto;
import models.domain.*;
import models.entities.EstadosEvento.*;

@Entity
@Table(name = "evento")
public class Evento extends EntidadPersistente implements Observee {
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "lugar")
	private String lugar;
	
	@Column(name = "fecha")
	private Instant fecha;
	
	@Column(name = "tipo")
    private String tipo;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "atuendo_id", referencedColumnName = "id")
    private Atuendo atuendo;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "guardarropa_id", referencedColumnName = "id")    
	private Guardarropa guardarropa;

	@ManyToOne( cascade = {CascadeType.ALL})
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
	
	@Column(name = "estado")
    private EstadoEvento estado;
	
	@Column(name = "repetir")
    private Boolean repetir;
	
	@Column(name = "repeticion_dias")
    private int repeticionDias;

    @Transient
    private GestorSugerencia gestorSugerencia;
    @Transient
    private CronGenerarSugerencia cronSugerencia;
    @Transient
    private GestorDeClima gestorClima;
    @Transient
    private CronNotificarSugerencia cronNotificarSugerencia;
	
    public Evento(EventoDto eventoDto){
    	this.gestorSugerencia = GestorSugerencia.getInstance();
    	this.cronNotificarSugerencia = CronNotificarSugerencia.getInstance();
    	this.cronSugerencia = CronGenerarSugerencia.getInstance();
    	this.gestorClima = GestorDeClima.getInstance();
    	this.nombre = eventoDto.nombre;
    	this.usuario = eventoDto.usuario;
    	this.estado = eventoDto.estado;
    	this.lugar = eventoDto.lugar;
    	this.setFecha(eventoDto.fecha);
    	this.guardarropa = eventoDto.guardarropa;
    	this.tipo = eventoDto.tipo;
    	this.repeticionDias = eventoDto.repeticionDias;
    	this.repetir = eventoDto.repetir;
    }

	public Evento() {
		this.gestorSugerencia = GestorSugerencia.getInstance();
		this.cronNotificarSugerencia = CronNotificarSugerencia.getInstance();
		this.cronSugerencia = CronGenerarSugerencia.getInstance();
		this.gestorClima = GestorDeClima.getInstance();
		this.estado = new Pendiente();
	}

	public void confirmarEvento(){
    	this.estado = new Pendiente();
    	this.cronSugerencia.registrar(this);
    }
    public void cancelarEvento(){
    	this.estado = new Inactivo();
    	this.cronSugerencia.sacar(this);
    }
    
    @Override
    public void ejecutar() {
    	this.estado.ejecutar(this);
    }
   
    // --- GETTERS Y SETTERS --- 
    
    public Instant getFecha(){ return this.fecha; }
    public void setFecha(String fecha){ // tiene que tener este formato: "2019-09-04T10:15:30Z";
    	DateTimeFormatter fmt = DateTimeFormatter.ISO_INSTANT;
    	Instant fechaEvento = fmt.parse(fecha, Instant::from);
    	this.fecha = fechaEvento;
    }
    public void setFecha(Instant fecha){ this.fecha = fecha; }
    public GestorSugerencia getGestorSugerencia(){ return this.gestorSugerencia; }
    public Integer getRepeticionDias(){ return this.repeticionDias; }
//    public Integer getAnticipacionHoras(){ return this.anticipacionHoras; }
    public Atuendo getAtuendo(){ return this.atuendo; }
    public Guardarropa getGuardarropa(){ return this.guardarropa; }
    public void setGuardarropa(Guardarropa guardarropa){ this.guardarropa = guardarropa; }
    public Usuario getUsuario(){ return this.usuario; }
    public void setAtuendo(Atuendo atuendo){ this.atuendo = atuendo; }
	public void setNombre(String unNombre){ this.nombre=unNombre; }
	public String getNombre(){ return this.nombre; }
	public void setLugar(String unLugar){ this.lugar=unLugar; }
	public String getLugar(){ return this.lugar; }
    public void setTipo(String tipo){ this.tipo = tipo; }
    public String getTipo(){ return this.tipo; }
    public void setEstado(EstadoEvento estado) { this.estado = estado; }
    public Boolean getRepetir(){ return this.repetir; }
    public EstadoEvento getEstado() { return this.estado; }
    public CronNotificarSugerencia getCronNotificarSugerencia() { return this.cronNotificarSugerencia; }
}
