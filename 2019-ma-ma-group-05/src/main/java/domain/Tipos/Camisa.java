package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Camisa extends Tipo{
	public Camisa(){
		this.categoria = Categoria.SUPERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
		this.nombre = "camisa";
		this.capa = Capa.CAMISA;
		this.nivelAbrigo = 12;	
	}
}