package domain.Categorias;

import javax.persistence.Transient;

import domain.Categoria;

public class Calzado extends Categoria {
	@Transient
	private static Calzado singleInstance = null;
	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
