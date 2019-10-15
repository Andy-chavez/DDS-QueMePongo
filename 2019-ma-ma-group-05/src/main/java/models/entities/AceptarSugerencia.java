package models.entities;

public class AceptarSugerencia extends OperacionesDeAtuendos{
	public AceptarSugerencia(Guardarropa g,Atuendo a){
		this.guardarropa=g;
		this.atuendo=a;
	}
	@Override
	public void ejecutar() {
		this.atuendo.setRechazado(false);
		this.guardarropa.agregarSugerencia(this.atuendo);
	}

}
