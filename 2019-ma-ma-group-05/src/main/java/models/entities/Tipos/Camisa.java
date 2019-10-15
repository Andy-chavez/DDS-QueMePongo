package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Algodon;
import models.entities.Telas.Nylon;
import models.entities.Telas.Poliester;
import models.entities.Telas.Seda;

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