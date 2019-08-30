package domain.Tipos;

import domain.Capa;
import domain.Categorias.*;

import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Cuero;
import domain.Telas.Nylon;
import domain.Telas.Seda;

public class Pantalon extends Tipo{
	public Pantalon(){
		this.categoria = new Inferior();
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Algodon());
		this.nombre = "pantalon";
		this.capa = 0;
		this.nivelAbrigo = 30;	
	}
}
