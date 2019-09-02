package domain.EstadosEvento;

import domain.Atuendo;
import domain.Evento;
import domain.GestorSugerencia;

public class SinRepeticion implements EstadoEvento{
	@Override
	public void run(Evento evento) {
		Atuendo atuendo = GestorSugerencia.getInstance().obtenerSugerencia(evento.getFecha(), evento.getGuardarropa(), evento.getUsuario().getSensibilidadFrio());
		evento.setAtuendo(atuendo);
		evento.cancel();
	}

}
