package domain.Tipos;

import java.util.EnumSet;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Tela;

public class Reloj extends Tipo{
	public Reloj(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles = EnumSet.of(Tela.OTRO);
		this.nombre = "reloj";
		this.capa = Capa.ACCESORIO;
		this.nivelAbrigo = 0;	
	}
}