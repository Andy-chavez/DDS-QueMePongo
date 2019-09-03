package domain;

import java.time.Duration;
import java.time.Instant;
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

public class CronNotificarSugerencia {
	private static CronNotificarSugerencia singleInstance = null;
	
	private CronNotificarSugerencia(){
	}
	public static CronNotificarSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new CronNotificarSugerencia();
		}
		return singleInstance;
	}
	
	public long milisegundosHastaFecha(Instant fecha){
	    return Duration.between(Instant.now(), fecha).toMillis();
	}
	
	public void planificarNotificacion(Evento evento){
		Timer timer = new Timer();
		int horasAnticipacionNotificacion = ConfigReader.getIntValue("configuraciones.properties", "horasAnticipacionNotificacion");
		Instant fechaNotificacion = evento.getFecha().minus(Duration.ofHours(horasAnticipacionNotificacion));
		long milisegundosHastaNotificacion = Instant.now().compareTo(fechaNotificacion) < 0 ? milisegundosHastaFecha(fechaNotificacion) : 0;
		timer.schedule(evento.getNotificadorEvento(), milisegundosHastaNotificacion, evento.getRepeticionDias());		
	}
}
