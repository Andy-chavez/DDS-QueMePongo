package entities.Telas;

import entities.Tela;

public class Poliester extends Tela{
    private static Poliester singleInstance = null;

	public static Poliester getInstance(){
		if(singleInstance == null){
			singleInstance = new Poliester();
		}
		return singleInstance;
	}
	public Poliester() {
		this.nombre = "poliester";
	}
}
