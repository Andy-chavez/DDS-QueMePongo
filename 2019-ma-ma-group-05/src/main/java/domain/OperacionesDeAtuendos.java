package domain;

public abstract class OperacionesDeAtuendos implements Operacion{
	protected Guardarropa guardarropa;
	protected Atuendo atuendo;
	
	public void deshacer() {
		this.atuendo.setRechazado(null);
		this.guardarropa.eliminarAtuendoSugerido(this.atuendo);
	}
}