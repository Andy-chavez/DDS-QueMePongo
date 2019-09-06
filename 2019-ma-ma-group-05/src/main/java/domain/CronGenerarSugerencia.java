package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.time.Duration;
import domain.Evento;


public class CronGenerarSugerencia extends TimerTask{
	private static CronGenerarSugerencia singleInstance = null;
	private Timer timer;
	private List<Evento> eventos;
	
	private CronGenerarSugerencia(){
		timer = new Timer();
		eventos = new ArrayList<Evento>();
//		timer.schedule(this, 0, Duration.ofHours(ConfigReader.getIntValue("configuraciones.properties", "intervaloGeneradorSugerencia")).toMillis());
	}
	public static CronGenerarSugerencia getInstance(){
		if(singleInstance == null){
			singleInstance = new CronGenerarSugerencia();
		}
		return singleInstance;
	}

	public void agregarEvento(Evento evento){
		this.eventos.add(evento);
	}
	public void sacarEvento(Evento evento){
		this.eventos.remove(evento);
	}
	
	@Override
	public void run() {
		eventos.forEach(e -> e.ejecutar());
	}
	
	public  List<Evento> getEventos(){
		return this.eventos;
	}
	
//	public Instant obtenerFechaSugerencia(Instant fecha){
//	    int diasAnticipacionSugerencia = ConfigReader.getIntValue("configuraciones.properties", "diasAnticipacionSugerencia");
//	    String horaSugerencia = ConfigReader.getStringValue("configuraciones.properties", "horaParaGenerarSugerencia");
//	    String fechaString = fecha.toString().substring(0, 10) + 'T' + horaSugerencia + 'Z';
//	    Instant fechaSugerencia = Instant.parse(fechaString);
//	    return fechaSugerencia.minus(Duration.ofDays(diasAnticipacionSugerencia));
//	}
//	
//	public long milisegundosHastaFecha(Instant fecha){
//	    return Duration.between(Instant.now(), fecha).toMillis();
//	}
//	
//	public void planificarEvento(Evento evento){
//		Timer timer = new Timer();
//		Instant fechaSugerencia = obtenerFechaSugerencia(evento.getFecha());
//		long milisegundosHastaSugerencia = Instant.now().compareTo(fechaSugerencia) < 0 ? milisegundosHastaFecha(fechaSugerencia) : 0;
//		timer.schedule(evento, milisegundosHastaSugerencia, evento.getRepeticionDias());		
//	}

}