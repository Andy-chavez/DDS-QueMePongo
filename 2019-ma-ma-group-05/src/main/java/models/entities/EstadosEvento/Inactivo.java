package models.entities.EstadosEvento;

import models.entities.Evento;

public class Inactivo implements EstadoEvento{
	@Override
	public void ejecutar(Evento evento) {
	}
}