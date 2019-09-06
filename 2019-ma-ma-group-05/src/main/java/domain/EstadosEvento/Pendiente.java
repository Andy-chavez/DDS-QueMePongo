package domain.EstadosEvento;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import domain.Atuendo;
import domain.ConfigReader;
import domain.Evento;

public class Pendiente implements EstadoEvento{

	public void ejecutar(Evento evento) {
		int diasAnticipacionSugernecia = ConfigReader.getIntValue("configuraciones.properties", "intervaloGeneradorSugerencia");
		if(Instant.now().until(evento.getFecha(), ChronoUnit.DAYS) <= diasAnticipacionSugernecia){
			Atuendo atuendo = evento.getGestorSugerencia().obtenerSugerencia(evento.getFecha(), evento.getGuardarropa(), evento.getUsuario().getSensibilidadFrio());
			evento.setAtuendo(atuendo);
			atuendo.reservarPrendas(evento.getFecha());			
			evento.setEstado(new AtuendoListo());
			evento.getAtuendo().printPrendas();
		}
	}
}
