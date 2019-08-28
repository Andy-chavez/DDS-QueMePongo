package domain.Tipos;

import domain.Categorias.*;
import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;

public class Sweater extends Tipo{
	public Sweater(){
		this.categoria = new SuperiorExtra();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "sweater";
		this.capa = 2;
		this.nivelAbrigo = 12;	
	}
}