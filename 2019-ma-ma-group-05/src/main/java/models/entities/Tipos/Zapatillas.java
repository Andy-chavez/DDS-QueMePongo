package models.entities.Tipos;

import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import converters.TipoAttributeConverter;
import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Algodon;
import models.entities.Telas.Cuero;
import models.entities.Telas.Seda;

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