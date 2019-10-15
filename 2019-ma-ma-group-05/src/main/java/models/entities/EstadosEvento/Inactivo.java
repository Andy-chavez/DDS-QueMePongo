package models.entities.EstadosEvento;

import models.entities.Atuendo;
import models.entities.Evento;
import models.entities.GestorSugerencia;

public class Inactivo implements EstadoEvento{
	@Override
	public void ejecutar(Evento evento) {
	}
}