package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Musculosa extends Tipo{
	public Musculosa(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
		this.nombre = "musculosa";
		this.capa = Capa.REMERA;
		this.nivelAbrigo = 8;	
	}
}