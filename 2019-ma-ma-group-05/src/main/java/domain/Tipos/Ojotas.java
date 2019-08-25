package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Ojotas extends Tipo{
	private String nombre = "ojotas";
	private Tela tela;
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.CUERO,Tela.NYLON,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.CALZADO;
	private Capa capa = Capa.CALZADO;
	private int nivelAbrigo = 1;

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