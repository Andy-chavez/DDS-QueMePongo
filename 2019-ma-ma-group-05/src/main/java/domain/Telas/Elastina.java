package domain.Telas;

import domain.Tela;

public class Elastina extends Tela {
    private static Elastina singleInstance = null;

	public static Elastina getInstance(){
		if(singleInstance == null){
			singleInstance = new Elastina();
		}
		return singleInstance;
	}
	public Elastina() {
		this.nombre = "elastina";
	}
}
