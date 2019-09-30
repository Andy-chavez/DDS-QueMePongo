package entities.Tipos;


import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;
import entities.Telas.Poliester;
import entities.Telas.Seda;

public class Campera extends Tipo{
	private static Campera instancia;
	public Campera(){
		this.categoria = SuperiorExtra.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "campera";
		this.capa = 3;
		this.nivelAbrigo = 25;	
	}
	
	public static Campera getInstance(){
		if(instancia==null){instancia=new Campera();}
		return instancia;
	}
}