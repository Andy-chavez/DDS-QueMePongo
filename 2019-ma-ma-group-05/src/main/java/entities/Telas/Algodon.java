package entities.Telas;

import entities.Tela;

public class Algodon extends Tela{
    private static Algodon singleInstance = null;

	public static Algodon getInstance(){
		if(singleInstance == null){
			singleInstance = new Algodon();
		}
		return singleInstance;
	}
	public Algodon() {
		this.nombre = "algodon";
	}
}
