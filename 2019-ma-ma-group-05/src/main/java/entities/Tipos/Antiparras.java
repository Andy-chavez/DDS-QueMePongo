package entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;

@Entity
@DiscriminatorValue("antiparras")
public class Antiparras extends Tipo{
	private static Antiparras instancia;

	public Antiparras(){
		this.categoria = Accesorio.getInstance();
		this.telasPosibles.add(new Algodon());
		this.telasPosibles.add(new Nylon());
		this.nombre = "antiparras";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
	public static Antiparras getInstance(){
		if(instancia==null){ instancia=new Antiparras();}
		return instancia;
	}
}