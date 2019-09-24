package entities.Categorias;

import javax.persistence.Transient;

import entities.Categoria;

public class Inferior extends Categoria {
	@Transient
	private static Inferior singleInstance = null;
	public static Inferior getInstance(){
		if(singleInstance == null){
			singleInstance = new Inferior();
		}
		return singleInstance;
	}
}
