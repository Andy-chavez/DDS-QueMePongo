package entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;
import entities.Telas.Poliester;
import entities.Telas.Seda;

@Entity
@DiscriminatorValue("camisa")
public class Camisa extends Tipo{
	private static Camisa instancia;
	public Camisa(){
		this.categoria = SuperiorBase.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "camisa";
		this.capa = 1;
		this.nivelAbrigo = 12;	
	}
	
	public static Camisa getInstance(){
		if(instancia==null){instancia=new Camisa();}
		return instancia;
	}
}