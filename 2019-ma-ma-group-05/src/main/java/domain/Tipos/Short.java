package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Short extends Tipo{

	public Short(){
		this.categoria = Categoria.INFERIOR;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
		this.nombre = "short";
		this.capa = Capa.PANTALON;
		this.nivelAbrigo = 15;	
	}
}