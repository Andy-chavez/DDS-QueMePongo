package domain.EstadosEvento;

import domain.Atuendo;
import domain.Evento;
import domain.GestorSugerencia;

public class Inactivo implements EstadoEvento{
	@Override
	public void run(Evento evento) {
		evento.cancel();
	}
}