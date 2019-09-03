package domain.Tipos;

import domain.Categorias.*;
import domain.Capa;
import domain.Categoria;
import domain.Tipo;
import domain.Telas.Algodon;
import domain.Telas.Nylon;
import domain.Telas.Poliester;
import domain.Telas.Seda;

public class Short extends Tipo{
	private static Short instancia;
	public Short(){
		this.categoria = new Inferior();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "short";
		this.capa = 0;
		this.nivelAbrigo = 15;	
	}
	public static Short getInstance(){
		if(instancia==null){instancia=new Short();}
		return instancia;
	}
}