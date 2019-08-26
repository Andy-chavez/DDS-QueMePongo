package domain.Tipos;

import java.util.ArrayList;
import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Tela;

public class Antiparras extends Tipo{
	public Antiparras(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "antiparras";
		this.capa = Capa.ACCESORIO;
		this.nivelAbrigo = 0;	
	}
}