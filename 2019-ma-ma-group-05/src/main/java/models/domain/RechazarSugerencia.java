package models.domain;

import models.entities.Atuendo;
import models.entities.Guardarropa;

public class RechazarSugerencia extends OperacionesDeAtuendos{
	public RechazarSugerencia(Guardarropa g, Atuendo a){
		this.guardarropa=g;
		this.atuendo=a;
	}
	@Override
	public void ejecutar() {
		this.atuendo.setRechazado(true);
		this.guardarropa.agregarSugerencia(this.atuendo);
	}
}
