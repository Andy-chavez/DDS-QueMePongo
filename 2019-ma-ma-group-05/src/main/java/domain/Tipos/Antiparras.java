package domain.Tipos;

import domain.Categorias.*;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;

public class Antiparras extends Tipo{
	public Antiparras(){
		this.categoria = new Accesorio();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "antiparras";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
}