package domain.Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;

public class Ojotas implements FamiliaTipos{
	private String tipo = "ojotas";
	private EnumSet<Tela> telasPosibles = EnumSet.of(Tela.CUERO,Tela.NYLON,Tela.SEDA,Tela.OTRO);
	private Categoria categoria = Categoria.CALZADO;
	
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