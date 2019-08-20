package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Antiparras extends Tipo{
	private String nombre = "antiparras";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.OTRO);
	private Tela tela;
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
		return nombre;
	}
	public EnumSet<Tela> getTelasPosibles() {
		return telasPosibles;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
}