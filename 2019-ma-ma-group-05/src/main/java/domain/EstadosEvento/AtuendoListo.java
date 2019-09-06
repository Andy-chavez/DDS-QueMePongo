package domain.EstadosEvento;

import java.time.Duration;
import java.time.Instant;

import domain.ConfigReader;
import domain.Evento;

public class AtuendoListo implements EstadoEvento{

	@Override
	public void ejecutar(Evento evento) { // se fija que haya pasado un dia desde el evento para liberar las prendas
		Duration duracionEvento = Duration.ofDays(ConfigReader.getIntValue("configuraciones.properties", "duracionEvento"));
		if(Instant.now().isAfter(evento.getFecha().plus(duracionEvento))){
			evento.getAtuendo().liberarPrendas(evento.getFecha());
			if(!evento.getRepetir()){
				evento.setEstado(new Inactivo());
			}
			else{
				// para testear (uso millis en vez de dias)
				evento.setFecha(evento.getFecha().plus(Duration.ofMillis(evento.getRepeticionDias())));
				
//				evento.setFecha(evento.getFecha().plus(Duration.ofDays(evento.getRepeticionDias())));
				evento.setEstado(new Pendiente());
			}
		}
	}

}
