package domain;

import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

import domain.Usuario;
import domain.Evento;


public class CronGenerarSugerencia {
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Usuario usuario = new Usuario(null); //null para que no joda con los errores
		Guardarropa guardarropa = new Guardarropa(null, null); //null para que no joda con los errores
		Evento evento = usuario.crearEvento("nombre", "lugar", 0, 0, 0); 
		/*hardcodeado para que no joda con los errores*/
		
		int anio = evento.getFecha().getYear();
		int mes = evento.getFecha().getMonthValue();
		int dia = evento.getFecha().getDayOfMonth();
		
		calendar.set(anio, mes, dia, 10, 0, 0);
		Date time = calendar.getTime();
		
		Timer timer = new Timer();
		
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				guardarropa.obtenerSugerencia();				
			}
		};
		
		timer.schedule(tarea, time, 86400000);
	}
}