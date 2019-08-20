package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Campera extends Tipo{
	private String tipo = "campera";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.SUPERIOR;
	private Capa capa = Capa.CAMPERA;
	private int nivelAbrigo = 15;

	public int getNivelAbrigo() {
		return nivelAbrigo;
	}

	public Capa getCapa() {
		return capa;
	}
	public String getTipo() {
		return tipo;
	}
	public EnumSet<Tela> getTelasPosibles() {
		return telasPosibles;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
}