package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;
@Entity
public class Inferior extends Categoria {
	protected Inferior(){
		this.setNombre("inferior");
	}
	private static Inferior singleInstance = null;

	public static Inferior getInstance(){
		if(singleInstance == null){
			singleInstance = new Inferior();
		}
		return singleInstance;
	}
}
