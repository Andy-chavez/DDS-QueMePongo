package domain.EstadosEvento;

import java.time.Duration;

import domain.Atuendo;
import domain.Evento;
import domain.GestorSugerencia;

public class Activo implements EstadoEvento{
	@Override
	public void run(Evento evento) {
		Atuendo atuendo = GestorSugerencia.getInstance().obtenerSugerencia(evento.getFecha(), evento.getGuardarropa(), evento.getUsuario().getSensibilidadFrio());
		evento.setFecha(evento.getFecha().plus(Duration.ofDays(evento.getRepeticionDias())));
		evento.setAtuendo(atuendo);
		evento.getAtuendo().printPrendas();
	}
}
