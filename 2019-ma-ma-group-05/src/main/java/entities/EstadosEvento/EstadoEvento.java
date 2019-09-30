package entities.EstadosEvento;

import java.time.Instant;

import entities.Evento;

public interface EstadoEvento {
	public void ejecutar(Evento evento);
}
