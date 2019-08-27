package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import domain.Usuario;
import services.EmailSender;
import services.WppSender;
import services.SmsSender;
import domain.Evento;

public class CronNotificarSugerencia {
	
	public static void main(Usuario usuario, Guardarropa guardarropa, String nombreEvento, String nombreGuardarropa) {
		Evento evento = usuario.getEvento(nombreEvento); 
		EmailSender email = new EmailSender();
		WppSender wpp = new WppSender();
		SmsSender sms = new SmsSender();
		Calendar calendar = Calendar.getInstance();
		
		int anio = evento.getFecha().getYear();
		int mes = evento.getFecha().getMonthValue();
		int dia = evento.getFecha().getDayOfMonth();
		
		calendar.set(anio, mes, dia, 10, 0, 0);
		Date time = calendar.getTime();
		
		Timer timer = new Timer();
		
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				usuario.obtenerSugerencia(usuario.getGuardarropa(nombreGuardarropa));
				wpp.enviar(usuario,"Sugerencia generada para un evento proximo!");
				sms.enviar(usuario,"Sugerencia generada para un evento proximo!");
				email.enviar(usuario,"¿Que me pongo?","¡Sugerencia generada para un evento proximo! Abra la app para ver mas detalles.");
			}
		};
		
		timer.schedule(tarea, time);
	}
}
