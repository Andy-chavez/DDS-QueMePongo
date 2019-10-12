package entities.Telas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import entities.Tela;

@Entity
@DiscriminatorValue("encaje")
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

