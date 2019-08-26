package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Short extends Tipo{
	private String nombre = "short";
	private Tela tela;
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.INFERIOR;
	private Capa capa = Capa.PANTALON;
	private int nivelAbrigo = 15;

	public int getNivelAbrigo() {
		return nivelAbrigo;
	}


	public Capa getCapa() {
		return capa;
	}
	public String getNombre() {
		return nombre;
	}
	public EnumSet<Tela> getTelasPosibles() {
		return telasPosibles;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
}