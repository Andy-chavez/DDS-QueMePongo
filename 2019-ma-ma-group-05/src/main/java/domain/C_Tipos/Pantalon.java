package domain.C_Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.C_FamiliaTipos;
import domain.Tela;

public class Pantalon implements C_FamiliaTipos{
	public String tipo = "pantalon";
	public EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.SEDA,Tela.OTRO);
	public Categoria categoria = Categoria.INFERIOR;
	
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
