package domain.C_Tipos;

import java.util.EnumSet;

import domain.Categoria;
import domain.C_FamiliaTipos;
import domain.Tela;

public class Reloj implements C_FamiliaTipos{
	public String tipo = "reloj";
	public EnumSet<Tela> telasPosibles = EnumSet.of(Tela.ALGODON,Tela.CUERO,Tela.NYLON,Tela.POLYESTER,Tela.OTRO);
	public Categoria categoria = Categoria.ACCESORIO;
	
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