package models.entities.Tipos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tipo;
import models.entities.Categorias.*;
import models.entities.Telas.Cuero;

@Entity
@DiscriminatorValue("reloj")
public class Reloj extends Tipo{
	private static Reloj instancia;
	public Reloj(){
		this.categoria = Accesorio.getInstance();
		this.telasPosibles.add(new Cuero());
		this.nombre = "reloj";
		this.capa = 0;
		this.nivelAbrigo = 0;	
	}
	public static Reloj getInstance(){
		if(instancia==null){instancia=new Reloj();}
		return instancia;
	}
}