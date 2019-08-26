package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Campera extends Tipo{
	public Campera(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
		this.nombre = "campera";
		this.capa = Capa.CAMPERA;
		this.nivelAbrigo = 25;	
	}
}