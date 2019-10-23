package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;
@Entity
public class Calzado extends Categoria {
	protected Calzado(){
		this.setNombre("calzado");
	}
	private static Calzado singleInstance = null;

	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
