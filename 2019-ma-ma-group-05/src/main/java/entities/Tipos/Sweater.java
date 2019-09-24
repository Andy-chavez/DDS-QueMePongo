package entities.Tipos;

import entities.Capa;
import entities.Categoria;
import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;
import entities.Telas.Poliester;
import entities.Telas.Seda;

public class Sweater extends Tipo{
	private static Sweater instancia;
	public Sweater(){
		this.categoria = SuperiorExtra.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "sweater";
		this.capa = 2;
		this.nivelAbrigo = 12;	
	}
	public static Sweater getInstance(){
		if(instancia==null){instancia=new Sweater();}
		return instancia;
	}
}