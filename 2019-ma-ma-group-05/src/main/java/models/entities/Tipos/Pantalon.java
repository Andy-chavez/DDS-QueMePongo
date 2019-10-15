package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Telas.Nylon;
import models.entities.Telas.Seda;

@Entity
@DiscriminatorValue("pantalon")
public class Pantalon extends Tipo{
	private static Pantalon instancia;
	public Pantalon(){
		this.categoria = Inferior.getInstance();
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Algodon());
		this.nombre = "pantalon";
		this.capa = 0;
		this.nivelAbrigo = 30;	
	}
	public static Pantalon getInstance(){
		if(instancia==null){instancia=new Pantalon();}
		return instancia;
	}
}
