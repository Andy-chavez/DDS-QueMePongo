package entities;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dtoClases.SenderDto;
import entities.Evento;
import services.EmailSender;
import services.WppSender;
import services.SmsSender;

public class CronNotificarSugerencia extends TimerTask{
	private List<Evento> eventos;
	private List<Sender> senders;
	private Timer timer;
	private static CronNotificarSugerencia singleInstance = null;
	private SenderDto dto;
	private CronNotificarSugerencia(){
		this.eventos = new ArrayList<Evento>();
		this.timer = new Timer();
		this.senders = new ArrayList<Sender>();
		this.cargarSenders();
		this.dto = new SenderDto();
		this.timer.schedule(this, 0, Duration.ofHours(ConfigReader.getIntValue("configuraciones.properties", "horasIntervaloNotificaciones")).toMillis());

	}
	private void cargarSenders() {
		this.senders.add(SmsSender.getInstance());
		this.senders.add(WppSender.getInstance());
		this.senders.add(EmailSender.getInstance());
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
	private String obtenerCelular(Evento evento) {
		return evento.getUsuario().getCelular();
	}
	private String obtenerMail(Evento evento) {
		return evento.getUsuario().getMail();
	}
	private void notificar(Evento evento) {
		this.dto.asunto = "¿Que me pongo?";
		this.dto.mensaje = "Hemos realizado tu sugerencia para el evento: " +
				evento.getNombre() + "en " + evento.getLugar() +
				". Para mas informacion, por favor, revisa la app :D"
				+ "\n Saludos, Grupo 5!";
		this.dto.mail = this.obtenerMail(evento);
		this.dto.celular = this.obtenerCelular(evento);
		this.senders.forEach(a->a.enviar(this.dto));
	}
	@Override
	public void run() {
		int horasAnticipacionNotificacion = ConfigReader.getIntValue("configuraciones.properties", "horasAnticipacionNotificacion");
		for(Evento evento : eventos){
			if(Instant.now().until(evento.getFecha(), ChronoUnit.HOURS) <= horasAnticipacionNotificacion){
				this.notificar(evento);
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
