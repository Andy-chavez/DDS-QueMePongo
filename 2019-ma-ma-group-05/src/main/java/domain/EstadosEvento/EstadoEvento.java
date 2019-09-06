package domain.EstadosEvento;

import java.time.Instant;

import domain.Evento;

public interface EstadoEvento {
	public void ejecutar(Evento evento);
}
