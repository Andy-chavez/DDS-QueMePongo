package entities.Tipos;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;

public class Remera extends Tipo{
	private static Remera instancia;
	public Remera(){
		this.categoria = SuperiorBase.getInstance();
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