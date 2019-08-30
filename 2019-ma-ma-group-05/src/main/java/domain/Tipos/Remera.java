package domain.Tipos;

import domain.Categorias.*;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;

public class Remera extends Tipo{
	public Remera(){
		this.categoria = new SuperiorBase();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "remera";
		this.capa = 0;
		this.nivelAbrigo = 10;	
	}
}
