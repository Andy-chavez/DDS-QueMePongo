package domain.Categorias;

import domain.Categoria;

public class Inferior extends Categoria {
	private static Inferior singleInstance = null;
	public static Inferior getInstance(){
		if(singleInstance == null){
			singleInstance = new Inferior();
		}
		return singleInstance;
	}
}
