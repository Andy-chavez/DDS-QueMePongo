package entities.Tipos;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Cuero;
import entities.Telas.Nylon;
import entities.Telas.Seda;

public class Pantalon extends Tipo{
	private static Pantalon instancia;
	public Pantalon(){
		this.categoria = Inferior.getInstance();
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Algodon());
		this.nombre = "pantalon";
		this.capa = 0;
		this.nivelAbrigo = 30;	
	}
	public static Pantalon getInstance(){
		if(instancia==null){instancia=new Pantalon();}
		return instancia;
	}
}
