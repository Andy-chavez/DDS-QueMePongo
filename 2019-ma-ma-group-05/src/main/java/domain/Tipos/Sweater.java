package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Sweater extends Tipo{
	public Sweater(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
		this.nombre = "sweater";
		this.capa = Capa.SWEATER;
		this.nivelAbrigo = 12;	
	}
}