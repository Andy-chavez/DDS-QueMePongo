package entities.Telas;

import entities.Tela;

public class Cuero extends Tela{
    private static Cuero singleInstance = null;

	public static Cuero getInstance(){
		if(singleInstance == null){
			singleInstance = new Cuero();
		}
		return singleInstance;
	}
	public Cuero() {
		this.nombre = "cuero";
	}
}
