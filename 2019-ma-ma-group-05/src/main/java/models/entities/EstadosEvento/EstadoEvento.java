package models.entities.EstadosEvento;

import java.time.Instant;

import models.entities.Evento;

public interface EstadoEvento {
	public void ejecutar(Evento evento);
}
