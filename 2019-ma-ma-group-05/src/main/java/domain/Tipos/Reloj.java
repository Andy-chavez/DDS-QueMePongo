package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Reloj extends Tipo{
	private String tipo = "reloj";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.CUERO,Tela.NYLON,Tela.POLYESTER,Tela.OTRO);
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