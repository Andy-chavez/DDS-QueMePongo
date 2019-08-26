package domain.Tipos;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;

public class Antiparras extends Tipo{
	public Antiparras(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "antiparras";
		this.capa = Capa.ACCESORIO;
		this.nivelAbrigo = 0;	
	}
}