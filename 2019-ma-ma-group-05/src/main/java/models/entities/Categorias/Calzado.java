package models.entities.Categorias;

import javax.persistence.*;

import models.entities.Categoria;

public class Calzado extends Categoria {

	private static Calzado singleInstance = null;

	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
