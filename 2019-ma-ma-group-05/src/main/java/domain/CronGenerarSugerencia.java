package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.Usuario;
import domain.Evento;


public class CronGenerarSugerencia {
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
	public void main(Guardarropa guardarropa, String nombreEvento, Usuario usuario) {

	    Evento evento = usuario.getEvento(nombreEvento);
		Calendar calendar = Calendar.getInstance();
			
		int anio = evento.getFecha().getYear();
		int mes = evento.getFecha().getMonthValue();
		int dia = evento.getFecha().getDayOfMonth();
			
		calendar.set(anio, mes, dia, 10, 0, 0);
		Date diaEvento = calendar.getTime();
	
		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DAY_OF_YEAR, -10); //se supone que genera sugerencias 10 dias antes del evento
		Date diezDiasAntes = cal.getTime();
	       
		Timer timer = new Timer();
			
		TimerTask tarea = new TimerTask() {
			@Override
	        public void run() {
				if(diezDiasAntes.before(diaEvento)){
					gestorSugerencia.obtenerSugerencia(scheduledExecutionTime(), guardarropa, new SensibilidadFrio());
					//TODO: reemplazar el scheduledExecutionTime() con la temperatura que esta como TODO en Usuario
	            }else{
	            	return; //ver si pasa al otro cron
				}
	          }
			};
			
		timer.schedule(tarea, diezDiasAntes, 8640000);
	}
}