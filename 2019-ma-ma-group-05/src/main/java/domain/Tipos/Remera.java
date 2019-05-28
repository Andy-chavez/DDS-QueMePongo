package domain.Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;

public class Remera implements FamiliaTipos{
	
	public String tipo = "remera";
	public EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON, Tela.NYLON,Tela.OTRO);
	public Categoria categoria = Categoria.SUPERIOR;
	
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
