package entities.Tipos;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Cuero;

public class Reloj extends Tipo{
	private static Reloj instancia;
	public Reloj(){
		this.categoria = Accesorio.getInstance();
		this.telasPosibles.add(new Cuero());
		this.nombre = "reloj";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
	public static Reloj getInstance(){
		if(instancia==null){instancia=new Reloj();}
		return instancia;
	}
}