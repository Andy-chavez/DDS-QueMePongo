package domain;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.EstadosEvento.EstadoEvento;
import domain.EstadosEvento.*;
import dtoClases.EventoDto;

public class Evento{
	private String nombre;
	private String lugar;
	private Instant fecha;
    private String tipo;
    private GestorSugerencia gestorSugerencia;
    private CronGenerarSugerencia cronSugerencia;
    private Atuendo atuendo;
    private Guardarropa guardarropa;
    private Usuario usuario;
    private EstadoEvento estado;
    private Boolean repetir;
    private int repeticionDias;
	
    public Evento(EventoDto eventoDto){
    	this.gestorSugerencia = GestorSugerencia.getInstance();
    	this.cronSugerencia = CronGenerarSugerencia.getInstance();
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
	    
    public void confirmarEvento(){
    	this.estado = new Pendiente();
    	this.cronSugerencia.agregarEvento(this);
    }
    public void cancelarEvento(){
    	this.estado = new Inactivo();
    	this.cronSugerencia.sacarEvento(this);
    }
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
}
