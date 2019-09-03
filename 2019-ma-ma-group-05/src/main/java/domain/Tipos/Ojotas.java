package domain.Tipos;

import domain.Capa;
import domain.Categorias.*;

import domain.Categoria;
import domain.Tipo;
import domain.Telas.Cuero;
import domain.Telas.Nylon;
import domain.Telas.Seda;

public class Ojotas extends Tipo{
	private static Ojotas instancia;
	public Ojotas(){
		this.categoria = new Calzado();
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.nombre = "ojotas";
		this.capa = 0;
		this.nivelAbrigo = 1;	
	}
	public static Ojotas getInstance(){
		if(instancia==null){instancia=new Ojotas();}
		return instancia;
	}
}