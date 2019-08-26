package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Antiparras extends Tipo{
	public Antiparras(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles = EnumSet.of(Tela.ALGODON,Tela.NYLON,Tela.OTRO);
		this.nombre = "antiparras";
		this.capa = Capa.ACCESORIO;
		this.nivelAbrigo = 0;	
	}
}