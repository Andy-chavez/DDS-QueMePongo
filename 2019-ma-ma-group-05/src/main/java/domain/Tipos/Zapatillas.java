package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Zapatillas extends Tipo{
	public Zapatillas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.CUERO,Tela.SEDA,Tela.OTRO);
		this.nombre = "zapatillas";
		this.capa = Capa.CALZADO;
		this.nivelAbrigo = 10;	
	}
}