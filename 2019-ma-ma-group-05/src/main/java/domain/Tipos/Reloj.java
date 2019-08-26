package domain.Tipos;

import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Cuero;

public class Reloj extends Tipo{
	public Reloj(){
		this.categoria = Categoria.ACCESORIO;
		this.telasPosibles.add(new Cuero());
		this.nombre = "reloj";
		this.capa = Capa.ACCESORIO;
		this.nivelAbrigo = 0;	
	}
}