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
public class Musculosa extends Tipo{
	private static Musculosa instancia;
	public Musculosa(){
		this.categoria = SuperiorBase.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "musculosa";
		this.capa = 0;
		this.nivelAbrigo = 8;	
	}
	
	public static Musculosa getInstance(){
		if(instancia==null){instancia= new Musculosa();}
		return instancia;
	}
}