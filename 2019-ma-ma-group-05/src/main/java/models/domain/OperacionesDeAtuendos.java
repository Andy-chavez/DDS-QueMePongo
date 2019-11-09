package models.domain;

import models.domain.Operacion;
import models.entities.Atuendo;
import models.entities.Guardarropa;

public abstract class OperacionesDeAtuendos implements Operacion {
	protected Guardarropa guardarropa;
	protected Atuendo atuendo;
	
	public void deshacer() {
		this.atuendo.setRechazado(null);
		this.guardarropa.eliminarAtuendoSugerido(this.atuendo);
	}

	public abstract void ejecutar();
		
}
