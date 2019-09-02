package domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.time.Duration;
import java.time.Instant;

import org.joda.time.LocalDateTime;

import domain.Usuario;
import domain.Evento;


public class CronGenerarSugerencia{
	private GestorSugerencia gestorSugerencia;
	private static CronGenerarSugerencia singleInstance = null;
	
	private CronGenerarSugerencia(){
		this.gestorSugerencia = GestorSugerencia.getInstance();
	}
	public static CronGenerarSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new CronGenerarSugerencia();
		}
		return singleInstance;
	}
	
//	public long milisegundosHastaFecha(Instant fecha){
//	    DateTimeFormatter fmt = DateTimeFormatter.ISO_INSTANT;
//	    int diasPreviosDeAvisoConfig = ConfigReader.getIntValue("configuraciones.properties", "diasPreviosDeAviso");
////	    int diasPreviosDeAviso = (int)Duration.between(Instant.now(), fecha).toDays() < diasPreviosDeAvisoConfig ? 0 : diasPreviosDeAvisoConfig;
//	    Instant fechaMenosDiasPrevios = fecha.minus(Duration.ofDays(diasPreviosDeAvisoConfig));
//	    String horaAviso = ConfigReader.getStringValue("configuraciones.properties", "horaParaGenerarSugerencia");
//	    String fechaString = fechaMenosDiasPrevios.toString().substring(0, 10) + 'T' + horaAviso + 'Z';
//	    Instant fechaAviso = fmt.parse(fechaString, Instant::from);
//	    System.out.println(fechaAviso);
//	    return Duration.between(Instant.now(), fechaAviso).toHours();
//	}
	
	public long milisegundosHastaFecha(Instant fecha){
	    return Duration.between(Instant.now(), fecha).toMillis();
	}
	
	public void planificarEvento(Evento evento){
		Timer timer = new Timer();
		long milisegundosTemp = milisegundosHastaFecha(evento.getFecha().minus(Duration.ofHours(evento.getAnticipacionHoras())));
		long milisegundosHastaAviso = milisegundosTemp >= 0 ? milisegundosTemp : 0;
		System.out.println(milisegundosHastaAviso);
		timer.schedule(evento, milisegundosHastaAviso, evento.getRepeticionDias());		
	}
}