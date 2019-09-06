package domain.Tipos;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;
import domain.Categorias.*;

public class Camisa extends Tipo{
	private static Camisa instancia;
	public Camisa(){
		this.categoria = new SuperiorBase();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "camisa";
		this.capa = 1;
		this.nivelAbrigo = 12;	
	}
	
	public static Camisa getInstance(){
		if(instancia==null){instancia=new Camisa();}
		return instancia;
	}
}