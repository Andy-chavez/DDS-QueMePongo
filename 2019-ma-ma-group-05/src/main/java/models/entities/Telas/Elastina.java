package models.entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tela;

@Entity
@DiscriminatorValue("elastina")
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
