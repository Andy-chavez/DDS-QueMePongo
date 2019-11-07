package models.domain;

public class GestorDeOperaciones {
	private Operacion ultimaOperacion;
	
	public void setUltimaOperacion(Operacion op){this.ultimaOperacion=op;}
	public Operacion getUltimaOperacion(){return this.ultimaOperacion;}
		
	public void deshacer(){
		this.ultimaOperacion.deshacer();
		this.ultimaOperacion=null;
	}
	public void ejecutar(Operacion op){
		op.ejecutar();
		this.ultimaOperacion=op;
	}
}
