package domain.Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;

public class Pantalon implements FamiliaTipos{
	private String tipo = "pantalon";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.INFERIOR;
	
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
