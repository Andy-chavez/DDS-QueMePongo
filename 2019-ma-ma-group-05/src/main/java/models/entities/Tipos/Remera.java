package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Algodon;
import models.entities.Telas.Nylon;

@Entity
@DiscriminatorValue("remera")
public class Remera extends Tipo{
	private static Remera instancia;
	public Remera(){
		this.categoria = SuperiorBase.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "remera";
		this.capa = 0;
		this.nivelAbrigo = 10;	
	}
	public static Remera getInstance(){
		if(instancia==null){instancia=new Remera();}
		return instancia;
	}
}
