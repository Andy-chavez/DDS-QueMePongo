package domain.C_Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.C_FamiliaTipos;
import domain.Tela;

public class Musculosa implements C_FamiliaTipos{
	public String tipo = "musculosa";
	public EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
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