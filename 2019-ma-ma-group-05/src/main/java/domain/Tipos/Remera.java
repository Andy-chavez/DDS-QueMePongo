package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Remera extends Tipo{
	public Remera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON, Tela.NYLON,Tela.OTRO);
		this.nombre = "remera";
		this.capa = Capa.REMERA;
		this.nivelAbrigo = 10;	
	}
}
