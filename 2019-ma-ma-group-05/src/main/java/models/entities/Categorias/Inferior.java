package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;

public class Inferior extends Categoria {

	private static Inferior singleInstance = null;

	public static Inferior getInstance(){
		if(singleInstance == null){
			singleInstance = new Inferior();
		}
		return singleInstance;
	}
}
