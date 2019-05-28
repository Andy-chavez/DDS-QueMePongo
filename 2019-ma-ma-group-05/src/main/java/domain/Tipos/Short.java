package domain.Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.FamiliaTipos;
import domain.Tela;
public class Short implements FamiliaTipos{
	public String tipo = "short";
	public EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.POLYESTER,Tela.SEDA,Tela.OTRO);
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