package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;

public class Antiparras implements FamiliaTipos{
	private String tipo = "antiparras";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.OTRO);
	private Categoria categoria = Categoria.ACCESORIO;
	private Capa capa = Capa.ACCESORIO;
	private int nivelAbrigo = 0;

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