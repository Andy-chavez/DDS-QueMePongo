package models.entities.EstadosEvento;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import models.entities.Atuendo;
import models.domain.ConfigReader;
import models.entities.Evento;
import models.repositorios.RepositorioEvento;

public class Pendiente implements EstadoEvento{

	public void ejecutar(Evento evento) {
		int diasAnticipacionSugernecia = ConfigReader.getIntValue("configuraciones.properties", "diasAnticipacionSugerencia");
		if(Instant.now().until(evento.getFecha(), ChronoUnit.DAYS) <= diasAnticipacionSugernecia){
			Atuendo atuendo = evento.getGestorSugerencia().obtenerSugerencia(evento.getFecha(), evento.getGuardarropa(), evento.getUsuario());
			evento.setAtuendo(atuendo);
//			evento.addAtuendoSugerido(atuendo);
//			atuendo.reservarPrendas(evento.getFecha());
			evento.setEstado(new AtuendoListo());
			RepositorioEvento.getInstance().modficar(evento);
			evento.getCronNotificarSugerencia().registrar(evento);
			evento.getAtuendo().printPrendas();
		}
	}
}
