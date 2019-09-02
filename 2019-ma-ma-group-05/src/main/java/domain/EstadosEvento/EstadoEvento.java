package domain.EstadosEvento;

import domain.Evento;

public interface EstadoEvento {
	public void run(Evento evento);
}
