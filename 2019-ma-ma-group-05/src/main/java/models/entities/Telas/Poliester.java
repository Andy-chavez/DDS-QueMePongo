package models.entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import models.entities.Tela;

@Entity
@DiscriminatorValue("poliester")
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
