package domain.Tipos;

import domain.Capa;
import domain.Categorias.*;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Cuero;

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