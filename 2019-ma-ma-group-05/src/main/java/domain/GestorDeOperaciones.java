package domain;

public class GestorDeOperaciones {
	private Operacion ultimaOperacion;
	private static GestorDeOperaciones instancia;
	
	public void setUltimaOperacion(Operacion op){this.ultimaOperacion=op;}
	public Operacion getUltimaOperacion(){return this.ultimaOperacion;}
	
	private GestorDeOperaciones(){}
	public static GestorDeOperaciones getInstance(){
		if(instancia==null){
			instancia=new GestorDeOperaciones();
		}
		return instancia;
	}
	
	public void deshacer(){
		this.ultimaOperacion.deshacer();
		this.ultimaOperacion=null;
	}
	public void ejecutar(Operacion op){
		op.ejecutar();
		this.ultimaOperacion=op;
	}
}
