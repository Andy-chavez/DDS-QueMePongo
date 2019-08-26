package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Ojotas extends Tipo{
	public Ojotas(){
		this.categoria = Categoria.CALZADO;
		this.telasPosibles = EnumSet.of(Tela.CUERO,Tela.NYLON,Tela.SEDA,Tela.OTRO);
		this.nombre = "ojotas";
		this.capa = Capa.CALZADO;
		this.nivelAbrigo = 1;	
	}	
}