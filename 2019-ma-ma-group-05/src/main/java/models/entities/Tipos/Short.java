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
@DiscriminatorValue("short")
public class Short extends Tipo{
	private static Short instancia;
	public Short(){
		this.categoria = Inferior.getInstance();
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