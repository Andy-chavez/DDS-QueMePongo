package domain.Telas;

import domain.Tela;

public class Seda extends Tela{
    private static Seda singleInstance = null;

	public static Seda getInstance(){
		if(singleInstance == null){
			singleInstance = new Seda();
		}
		return singleInstance;
	}
	public Seda() {
		this.nombre = "seda";
	}
}