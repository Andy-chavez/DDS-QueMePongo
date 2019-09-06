package domain.Tipos;

import domain.Categorias.*;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;

public class Remera extends Tipo{
	private static Remera instancia;
	public Remera(){
		this.categoria = new SuperiorBase();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "remera";
		this.capa = 0;
		this.nivelAbrigo = 10;	
	}
	public static Remera getInstance(){
		if(instancia==null){instancia=new Remera();}
		return instancia;
	}
}
