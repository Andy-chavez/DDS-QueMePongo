package entities.Tipos;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;
import entities.Telas.Poliester;
import entities.Telas.Seda;

public class Musculosa extends Tipo{
	private static Musculosa instancia;
	public Musculosa(){
		this.categoria = SuperiorBase.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "musculosa";
		this.capa = 0;
		this.nivelAbrigo = 8;	
	}
	
	public static Musculosa getInstance(){
		if(instancia==null){instancia= new Musculosa();}
		return instancia;
	}
}