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
public class Campera extends Tipo{
	private static Campera instancia;
	public Campera(){
		this.categoria = SuperiorExtra.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "campera";
		this.capa = 3;
		this.nivelAbrigo = 25;	
	}
	
	public static Campera getInstance(){
		if(instancia==null){instancia=new Campera();}
		return instancia;
	}
}