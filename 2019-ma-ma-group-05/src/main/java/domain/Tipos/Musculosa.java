package domain.Tipos;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;
import domain.Categorias.*;

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