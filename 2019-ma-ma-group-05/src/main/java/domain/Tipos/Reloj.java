package domain.Tipos;

import domain.Capa;
import domain.Categorias.*;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Cuero;

public class Reloj extends Tipo{
	public Reloj(){
		this.categoria = new Accesorio();
		this.telasPosibles.add(new Cuero());
		this.nombre = "reloj";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
}