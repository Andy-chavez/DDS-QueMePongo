package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Telas.Seda;

@Entity
@DiscriminatorValue("zapatillas")
public class Zapatillas extends Tipo{
	private static Zapatillas instancia;
	public Zapatillas(){
		this.categoria = Calzado.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Cuero());
		this.telasPosibles.add(new Seda());
		this.nombre = "zapatillas";
		this.capa = 0;
		this.nivelAbrigo = 10;	
	}
	public static Zapatillas getInstance(){
		if(instancia==null){instancia=new Zapatillas();}
		return instancia;
	}
}