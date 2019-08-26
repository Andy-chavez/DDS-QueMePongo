package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Cuero;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;
import domain.Tela;

public class Musculosa extends Tipo{
	public Musculosa(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "musculosa";
		this.capa = Capa.REMERA;
		this.nivelAbrigo = 8;	
	}
}