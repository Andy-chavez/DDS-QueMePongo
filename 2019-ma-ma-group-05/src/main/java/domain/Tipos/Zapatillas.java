package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;
public class Zapatillas implements FamiliaTipos{
	private String tipo = "zapatillas";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.CUERO,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.CALZADO;
	private Capa capa = Capa.CALZADO;
	private int nivelAbrigo = 5;

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