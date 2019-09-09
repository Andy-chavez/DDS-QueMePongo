package domain;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import domain.Usuario;
import dtoClases.SenderDto;
import services.EmailSender;
import services.WppSender;
import services.SmsSender;
import domain.Evento;

public class CronNotificarSugerencia extends TimerTask{
	private List<Evento> eventos;
	private Timer timer;
	private static CronNotificarSugerencia singleInstance = null;
	
	private CronNotificarSugerencia(){
		this.eventos = new ArrayList<Evento>();
		this.timer = new Timer();
		this.timer.schedule(this, 0, Duration.ofHours(ConfigReader.getIntValue("configuraciones.properties", "horasIntervaloNotificaciones")).toMillis());

	}
	public static CronNotificarSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new CronNotificarSugerencia();
		}
		return singleInstance;
	}
	
	public void registrar(Evento evento) {
		eventos.add(evento);	
	}
	public void sacar(Evento evento) {
		eventos.remove(evento);
	}
	@Override
	public void run() {
		int horasAnticipacionNotificacion = ConfigReader.getIntValue("configuraciones.properties", "horasAnticipacionNotificacion");
		for(Evento evento : eventos){
			if(Instant.now().until(evento.getFecha(), ChronoUnit.HOURS) <= horasAnticipacionNotificacion){
				// TODO: notificar usuario
				sacar(evento); // notifica una vez y lo saca de la lista (cuando se programa un nuevo evento se agrega solo)
			}
		}
		
	}
//	public long milisegundosHastaFecha(Instant fecha){
//	    return Duration.between(Instant.now(), fecha).toMillis();
//	}
//	
//	public void planificarNotificacion(Evento evento){
//		Timer timer = new Timer();
//		int horasAnticipacionNotificacion = ConfigReader.getIntValue("configuraciones.properties", "horasAnticipacionNotificacion");
//		Instant fechaNotificacion = evento.getFecha().minus(Duration.ofHours(horasAnticipacionNotificacion));
//		long milisegundosHastaNotificacion = Instant.now().compareTo(fechaNotificacion) < 0 ? milisegundosHastaFecha(fechaNotificacion) : 0;
//		timer.schedule(evento.getNotificadorEvento(), milisegundosHastaNotificacion, evento.getRepeticionDias());		
//	}
}
