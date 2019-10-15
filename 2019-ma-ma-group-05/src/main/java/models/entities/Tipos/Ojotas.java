package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Cuero;
import models.entities.Telas.Nylon;
import models.entities.Telas.Seda;

@Entity
@DiscriminatorValue("ojotas")
public class Ojotas extends Tipo{
	private static Ojotas instancia;
	public Ojotas(){
		this.categoria = Calzado.getInstance();
		this.telasPosibles.add(new Nylon());
		this.telasPosibles.add(new Seda());
		this.telasPosibles.add(new Cuero());
		this.nombre = "ojotas";
		this.capa = 0;
		this.nivelAbrigo = 1;	
	}
	public static Ojotas getInstance(){
		if(instancia==null){instancia=new Ojotas();}
		return instancia;
	}
}