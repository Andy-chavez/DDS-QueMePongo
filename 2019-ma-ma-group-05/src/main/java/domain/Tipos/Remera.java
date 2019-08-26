package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;
import domain.Tela;

public class Remera extends Tipo{
	public Remera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "remera";
		this.capa = Capa.REMERA;
		this.nivelAbrigo = 10;	
	}
}
