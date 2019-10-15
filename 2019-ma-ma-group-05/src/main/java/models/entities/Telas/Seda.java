package models.entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tela;

@Entity
@DiscriminatorValue("seda")
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