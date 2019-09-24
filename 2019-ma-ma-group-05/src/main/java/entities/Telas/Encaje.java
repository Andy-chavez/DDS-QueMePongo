package entities.Telas;

import entities.Tela;

public class Encaje extends Tela{
    private static Encaje singleInstance = null;

	public static Encaje getInstance(){
		if(singleInstance == null){
			singleInstance = new Encaje();
		}
		return singleInstance;
	}
	public Encaje() {
		this.nombre = "encaje";
	}
}

