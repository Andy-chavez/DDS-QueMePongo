package domain.Categorias;

import domain.Categoria;

public class Calzado extends Categoria {
	private static Calzado singleInstance = null;
	public static Calzado getInstance(){
		if(singleInstance == null){
			singleInstance = new Calzado();
		}
		return singleInstance;
	}
}
