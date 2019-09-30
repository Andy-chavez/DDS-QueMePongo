package entities.Telas;

import entities.Tela;

public class Nylon extends Tela{
    private static Nylon singleInstance = null;

	public static Nylon getInstance(){
		if(singleInstance == null){
			singleInstance = new Nylon();
		}
		return singleInstance;
	}
	public Nylon() {
		this.nombre = "nylon";
	}
}
