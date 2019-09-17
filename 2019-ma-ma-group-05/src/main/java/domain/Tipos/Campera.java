package domain.Tipos;

import domain.Capa;
import domain.Categorias.*;

import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;

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