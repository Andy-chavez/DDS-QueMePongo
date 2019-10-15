package models.entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tela;

@Entity
@DiscriminatorValue("algodon")
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
