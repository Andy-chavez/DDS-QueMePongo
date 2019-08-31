package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import dtoClases.EventoDto;

public class Evento extends TimerTask{
	private String nombre;
	private String lugar;
	private LocalDate fecha;
    private String tipo;
    private GestorSugerencia gestorSugerencia;
    private Atuendo atuendo;
    private Guardarropa guardarropa;
    private Usuario usuario;
    private GestorDeClima gestorClima;
    private Boolean caducado; //esto es algo que me acuerdo que eze corrigio en clase a todos
	
    public Evento(EventoDto eventoDto){
    	gestorSugerencia.getInstance();
    	gestorClima.getInstance();
    	caducado = false;
    	this.nombre = eventoDto.nombre;
    	this.usuario = eventoDto.usuario;
    	this.lugar = eventoDto.lugar;
    	this.fecha = eventoDto.fecha;
    	this.guardarropa = eventoDto.guardarropa;
    	this.tipo = eventoDto.tipo;
    }
	public LocalDate getFecha(){
		return this.fecha;
	}
    
    // TODO: repetir evento: cambia el estado de Caducado a Pendiente
    
    @Override
    public void run() {
    	if(!caducado){
    		this.atuendo = gestorSugerencia.obtenerSugerencia(this.fecha, this.guardarropa, this.usuario.getSensibilidadFrio());
    	}
    	else{
	    	System.out.println("eeexito");
	    	this.cancel();
    	}
    }
    
//	public void setNombre(String unNombre){this.nombre=unNombre;}
//	public String getNombre(){return this.nombre;}
//	
//	public void setLugar(String unLugar){this.lugar=unLugar;}
//	public String getLugar(){return this.lugar;}
//	
//	public void setFecha(int anio,int  mes,int dia){this.fecha= LocalDate.of(anio, mes, dia);}
//	public LocalDate getFecha(){return this.fecha;}
//       
//    public void setTipo(String tipo){this.tipo = tipo;}
//    public String getTipo(){return this.tipo;}

//	public static void main(String[] args){
//		Timer timer = new Timer();
//		Evento evento = new Evento("fiesta", "pacha", LocalDate.now(), "formal");
//		timer.schedule(evento, 1, 1);
//	}
}
