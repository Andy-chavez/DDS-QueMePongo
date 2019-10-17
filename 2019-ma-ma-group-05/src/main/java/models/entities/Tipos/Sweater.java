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
public class Sweater extends Tipo{
	private static Sweater instancia;
	public Sweater(){
		this.categoria = SuperiorExtra.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Poliester());
		this.nombre = "sweater";
		this.capa = 2;
		this.nivelAbrigo = 12;	
	}
	public static Sweater getInstance(){
		if(instancia==null){instancia=new Sweater();}
		return instancia;
	}
}