package domain.Tipos;

import domain.Categorias.*;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;

public class Antiparras extends Tipo{
	private static Antiparras instancia;

	public Antiparras(){
		this.categoria = new Accesorio();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "antiparras";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
	public static Antiparras getInstance(){
		if(instancia==null){ instancia=new Antiparras();}
		return instancia;
	}
}