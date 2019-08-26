package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Pantalon extends Tipo{
	public Pantalon(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.SEDA,Tela.OTRO);
		this.nombre = "pantalon";
		this.capa = Capa.PANTALON;
		this.nivelAbrigo = 30;	
	}
}
