package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Cuero;
import domain.Telas.Nylon;
import domain.Telas.Seda;
import domain.Tela;

public class Zapatillas extends Tipo{
	public Zapatillas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Seda());
		this.nombre = "zapatillas";
		this.capa = Capa.CALZADO;
		this.nivelAbrigo = 10;	
	}
}