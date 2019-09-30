package entities.Tipos;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Cuero;
import entities.Telas.Nylon;
import entities.Telas.Seda;

public class Ojotas extends Tipo{
	private static Ojotas instancia;
	public Ojotas(){
		this.categoria = Calzado.getInstance();
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