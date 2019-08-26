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

public class Ojotas extends Tipo{
	public Ojotas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		//this.telasPosibles = EnumSet.of(Tela.CUERO,Tela.NYLON,Tela.SEDA,Tela.OTRO);
		this.nombre = "ojotas";
		this.capa = Capa.CALZADO;
		this.nivelAbrigo = 1;	
	}	
}