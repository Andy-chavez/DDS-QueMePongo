package entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tipo;
import entities.Categorias.*;
import entities.Telas.Algodon;
import entities.Telas.Nylon;
import entities.Telas.Poliester;
import entities.Telas.Seda;

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