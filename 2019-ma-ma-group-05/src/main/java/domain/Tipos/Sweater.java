package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;

public class Sweater implements FamiliaTipos{
	private String tipo = "sweater";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.SUPERIOR;
	private Capa capa = Capa.SWEATER;
	private int nivelAbrigo = 12;

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