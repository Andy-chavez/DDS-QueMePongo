package domain;

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
	
	public static void main(Usuario usuario, Guardarropa guardarropa, String nombreEvento, String nombreGuardarropa) {
		Evento evento = usuario.getEvento(nombreEvento);
		List<Sender> senders = new ArrayList<>();
		EmailSender email = new EmailSender();
		WppSender wpp = new WppSender();
		SmsSender sms = new SmsSender();
		senders.add(wpp);
		senders.add(sms);
		senders.add(email);
		SenderDto dto = new SenderDto();
		dto.asunto = "¿Que me pongo?";
		dto.mensaje = "¡Sugerencia generada para un evento proximo! Abra la app para ver mas detalles.";
		dto.celular = usuario.getCelular();
		dto.mail = usuario.getMail();
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
				senders.stream().forEach(sender -> sender.enviar(dto));
			}
		};
		
		timer.schedule(tarea, time);
	}
}
