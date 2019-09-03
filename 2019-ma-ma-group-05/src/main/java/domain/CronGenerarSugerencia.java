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
	
	public Instant obtenerFechaSugerencia(Instant fecha){
	    int diasAnticipacionSugerencia = ConfigReader.getIntValue("configuraciones.properties", "diasAnticipacionSugerencia");
	    String horaSugerencia = ConfigReader.getStringValue("configuraciones.properties", "horaParaGenerarSugerencia");
	    String fechaString = fecha.toString().substring(0, 10) + 'T' + horaSugerencia + 'Z';
	    Instant fechaSugerencia = Instant.parse(fechaString);
	    return fechaSugerencia.minus(Duration.ofDays(diasAnticipacionSugerencia));
	}
	
	public long milisegundosHastaFecha(Instant fecha){
	    return Duration.between(Instant.now(), fecha).toMillis();
	}
	
	public void planificarEvento(Evento evento){
		Timer timer = new Timer();
		Instant fechaSugerencia = obtenerFechaSugerencia(evento.getFecha());
		long milisegundosHastaSugerencia = Instant.now().compareTo(fechaSugerencia) < 0 ? milisegundosHastaFecha(fechaSugerencia) : 0;
		timer.schedule(evento, milisegundosHastaSugerencia, evento.getRepeticionDias());		
	}
}